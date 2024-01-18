package edu.penzgtu.opp.MergeSortExample;

public class MergeSortExample {
    public static void main(String[] args) {
        double[] array = {12.3, 5.5, 8.9, 1.1, 3.7, 7.6, 9.2};
        mergeSort(array, 0, array.length - 1);

        System.out.println("Отсортированный массив: ");
        for (double v : array) {
            System.out.print(v + " ");
        }
    }

    public static void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public static void merge(double[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        double[] L = new double[n1];
        double[] R = new double[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, middle + 1, R, 0, n2);

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}