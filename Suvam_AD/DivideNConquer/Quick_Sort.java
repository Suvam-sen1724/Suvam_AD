/*
Pseudo-code:
QuickSort(A, p, r):
  if p < r then:
    q = Partition(A, p, r)
    QuickSort(A, p, q - 1)
    QuickSort(A, q + 1, r)

*/

//Code:
package DivideNConquer;

import java.util.Arrays;

class QuickSort {
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}

public class Quick_Sort {
    public static void main(String[] args) {
        // input
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        // output
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));

    }
}
