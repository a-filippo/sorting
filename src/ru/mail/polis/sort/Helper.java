package ru.mail.polis.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] gen(int n) {
        int[] a = new int[n];
        int k = 0;
        while (k < n){
            int m = r.nextInt(n / 10);
            for (int i = 0; i < m; i++){
                if (k + i >= a.length) {
                    break;
                }
                a[k + i]=k;
            }
            k += m;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    public static int[] partSortArray(int n){
        int[] a = new int[n];
        int k = r.nextInt(n / 2 + 1) - (n / 2 - n / 4);
        for (int i = 0; i < a.length; i++) {
            a[i] = k++;
            if (k == a.length){
                k = 1;
            }
        }
        return a;
    }

    public static int[] sortArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        return a;
    }

    public static int[] reverseArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = n - 1 - i;
        }
        return a;
    }

    public static int[] partitionArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = i + 1;
        }
        for (int i = 2; i < n; i++){
            swap(a, i, i / 2);
        }
        return a;
    }
}
