/*
Pseudo-code:
CountInversions(A, p, r):
  if p < r then:
    q = floor((p + r) / 2)
    left = CountInversions(A, p, q)
    right = CountInversions(A, q + 1, r)
    cross = MergeAndCount(A, p, q, r)
    return left + right + cross
  return 0

*/


//Code:

package DivideNConquer;

import java.util.Arrays;

class CountInversions {
    static int mergeAndCount(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

    static int countInversions(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += countInversions(arr, l, m);
            count += countInversions(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }
}

public class Counting_Inversions {
    public static void main(String[] args) {
        //input
        int arr[] = {1, 20, 6, 4, 5};

        //output
        System.out.println(CountInversions.countInversions(arr, 0, arr.length - 1));

    }
}
