package ru.mail.polis.sort;


public class InsertionSort {
    public static int[] sort(int a[]) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                a[j] = a[j] ^ a[j - 1] ^ (a[j - 1] = a[j]);
            }
        }
        return a;
    }
}
