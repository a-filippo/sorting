package ru.mail.polis.sort;



public class KOrder {
    public static int sort(int a[], int k) {
        findK(a, k);
        return a[k];
    }

    private static void findK(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        while (right > left) {
            int i = left + (right - left + 1) / 2;
            int mid = partition(a, left, right, i);
            if (k < mid) {
                right = mid - 1;
            } else if (k > mid){
                left = mid + 1;
            } else {
                return;
            }
        }
    }


    private static int partition(int[] a, int left, int right, int pivot) {
        if (left > right) return right;

        int p = a[pivot];
        int i = left;
        int j = right;
        Helper.swap(a, j--, pivot);
        while (i <= j) {
            while (i <= j && a[i] < p) i++;
            while (i <= j && a[j] > p) j--;
            if (i >= j) {
                break;
            }
            Helper.swap(a, i++, j--);
        }
        Helper.swap(a,i,right);
        return i;
    }
}
