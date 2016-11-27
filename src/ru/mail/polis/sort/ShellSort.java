package ru.mail.polis.sort;


public class ShellSort {
    public static int[] sort(int a[]) {
        int n = a.length;
        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    a[j] = a[j] ^ a[j - h] ^ (a[j - h] = a[j]);
                }
            }
            h /= 3;
        }

        return a;
    }
}
