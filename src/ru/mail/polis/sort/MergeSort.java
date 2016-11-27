package ru.mail.polis.sort;


public class MergeSort {

    public static int[] sort(int a[]) {
        int n = a.length;
        int t[] = new int[n];
        for (int len = 1; len < n; len *= 2) {
            for (int left = 0; left < n - len; left += len * 2) {
                int mid = left + len - 1;
                int right = Math.min(left + len + len - 1, n - 1);
                merge(a, t, left, mid, right);
            }
        }
        return a;
    }

    private static void merge(int[] a, int[] t, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            t[i] = a[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid){
                a[k] = t[j++];
            } else if (j > right){
                a[k] = t[i++];
            } else if (t[j] < t[i]){
                a[k] = t[j++];
            } else {
                a[k] = t[i++];
            }
        }
    }
}