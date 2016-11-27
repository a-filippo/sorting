package ru.mail.polis.sort;


public class QuickSort {
    public static int[] sort(int a[]) {
        qsort(a, 0, a.length - 1);
        return a;
    }
    private static void qsort(int[] a, int left, int right) {
        if (left >= right){
            return;
        }
        int idx = partition(a, left, right);
        qsort(a, left, idx);
        qsort(a, idx + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int p = a[left + (right - left + 1) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (a[i] < p){
                i++;
            }
            while (a[j] > p){
                j--;
            }
            if (i <= j) {
                a[j] = a[j] ^ a[i] ^ (a[i] = a[j]);
                i++;
                j--;
            }
        }
        return j;
    }
}
