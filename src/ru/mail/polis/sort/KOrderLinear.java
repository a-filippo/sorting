package ru.mail.polis.sort;


public class KOrderLinear {


    private static void isort(int[] a, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                Helper.swap(a, j - 1, j);
            }
        }
    }

    public static int sort(int arr[], int k) {
        findK(arr, k);
        return arr[k];
    }

    private static int findMed(int[] a, int left, int right) {
        int res;
        int i = left;
        int j = 0;
        int[] meds = new int[(right + 4) / 5];
        while (i + 4 < right) {
            isort(a, i, i + 4);
            meds[j++] = a[i + 2];
            i += 5;
        }
        if ((right % 5) != 0){
            if (j != 0){
                i -= 5;
            }
            isort(a, i, a.length-1);
            meds[j++] = a[(a.length - 1 - i) / 2];
        }
        if (j==1) {
            res = a[0];
            return res;
        }
        res = findMed(meds, 0, meds.length);
        return res;
    }

    private static void findK(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        while (right > left) {
            int pivot = findMed(a,left, right+1);
            int mid = partition(a, left, right, pivot);
            if (k < mid) {
                right = mid - 1;
            } else if (k > mid){
                left = mid + 1;
            } else {
                return;
            }
        }
    }


    private static int partition(int[] a, int left, int right, int p) {
        if (left > right) return right;
        int i = left;
        int j = right;
        while (i <= j) {
            while (i <= j && a[i] < p) i++;
            while (i <= j && a[j] > p) j--;
            if (i >= j) {
                break;
            }
            Helper.swap(a, i++, j--);
        }
        return i;
    }
}
