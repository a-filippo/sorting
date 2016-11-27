package ru.mail.polis.sort;


public class MergeWithoutMemorySort {

    public static int[] sort(int a[]) {
        msort(a, a.length);
        return a;
    }

    private static void msort(int[] arr, int len) {
        int s = (int) Math.sqrt(len);
        int i = s;
        int bound = 0;

        while (i < len) {
            if (arr[i - 1] > arr[i]) {
                bound = i - (i % s);
                break;
            }
            i++;
        }

        int begBuf = len - (len % s) - s;
        swapElements(arr, bound, begBuf, s);
        sortBlocks(arr, begBuf - s, s);
        i = 0;

        while (i + s < begBuf) {
            merge(arr, i, s, begBuf, s);
            i += s;
        }

        int ss = s + (len % s);

        sortel(arr, len - 2 * ss, len - 1);

        if (len > 10) {
            merge(arr, ss, ss, 0, ss);
        }

        sortel(arr, 0, ss);

        if (len - ss > 10){
            msort(arr, len - ss);
        }

        sortel(arr, 0, 7);
    }

    private static void swapElements(int[] arr, int beg1, int beg2, int cnt) {

        for (int i = beg1, j = beg2; i < beg1 + cnt; i++, j++) {
            Helper.swap(arr, i, j);
        }
    }

    private static void sortBlocks(int[] arr, int bLast, int len) {
        for (int i = 0; i < bLast; i += len) {
            int min = i;
            for (int j = i + len; j <= bLast; j += len) {
                if (arr[j] < arr[i] || (arr[j] == arr[i] && arr[j + len - 1] < arr[i + len - 1])) min = j;
            }
            swapElements(arr, i, min, len);
        }
    }

    private static void merge(int[] arr, int beg1, int len1, int buf, int len2) {
        swapElements(arr, beg1, buf, len1);
        int first = buf;
        int second = beg1 + len1;
        int j = beg1;
        while (true) {
            if (arr[first] <= arr[second]) {
                Helper.swap(arr, first, j);
                if (++first > buf + len1 - 1) {
                    if (++j == beg1 + len1 + len2){
                        j = buf;
                    }
                    swapElements(arr, second, j, beg1 + 2 * len2 - second);
                    break;
                }
            } else {
                Helper.swap(arr, second, j);
                if (++second > beg1 + 2 * len2 - 1) {
                    if (++j == beg1 + len1 + len2) {
                        j = buf;
                    }
                    swapElements(arr, first, j, buf + len1 - first);
                    break;
                }
            }
            if (++j == beg1 + len1 + len2){
                j = buf;
            }
        }

    }

    private static void sortel(int[] arr, int right, int left) {
        for (int i = right; i < left; i++) {
            int min = i;
            for (int j = i + 1; j <= left; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            Helper.swap(arr, i, min);
        }
    }
}
