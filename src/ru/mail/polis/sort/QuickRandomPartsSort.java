package ru.mail.polis.sort;


import java.util.Random;

public class QuickRandomPartsSort {
    private static Random random = new Random(System.currentTimeMillis());

    public static int[] sort(int a[]) {
        qsort(a, 0, a.length - 1);
        return a;
    }

    private static void qsort(int[] a, int left, int right) {
        if (left >= right) return;

        int ind = random.nextInt(right - left) + left;
        int pivot = a[ind];
        int p = left;
        int j = left;

        Helper.swap(a, left, ind);

        for (int i = left + 1; i <= right; i++){
            if (a[i] < pivot){
                Helper.swap(a, ++j, i);
            } else if (a[i] == pivot){
                Helper.swap(a, i, ++j);
                Helper.swap(a, ++p, j);
            }
        }

        int q = j;

        for (int i = left; i <= p; i++){
            Helper.swap(a,i,j--);
        }

        qsort(a, left, j);
        qsort(a,q+1, right);
    }
}
