/*
Pseudo-code:
MatrixChainOrder(p, n):
Declare matrix m of size n x n
for i = 1 to n
    m[i][i] = 0
for L = 2 to n
    for i = 1 to n - L + 1
        j = i + L - 1
        m[i][j] = infinity
        for k = i to j - 1
            q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]
            if q < m[i][j]
                m[i][j] = q
return m[1][n - 1]

*/


//Code:
package DP;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        // input
        int arr[] = new int[] {1, 2, 3, 4, 3};

        // output
        System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, arr.length));
    }

    static int MatrixChainOrder(int p[], int n) {
        int m[][] = new int[n][n];
        int i, j, k, L, q;

        for (i = 1; i < n; i++)
            m[i][i] = 0;

        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                if (j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }
}

