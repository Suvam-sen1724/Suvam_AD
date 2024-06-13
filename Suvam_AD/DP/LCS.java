/*
Pseudo-code:
LCS(X, Y):
m = length(X)
n = length(Y)
Declare L[m+1][n+1]
for i = 0 to m
    for j = 0 to n
        if i == 0 or j == 0
            L[i][j] = 0
        else if X[i-1] == Y[j-1]
            L[i][j] = L[i-1][j-1] + 1
        else
            L[i][j] = max(L[i-1][j], L[i][j-1])
return L[m][n]

*/


//Code:
package DP;

public class LCS {
    public static void main(String[] args) {
        // input
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        // output
        System.out.println("Length of LCS is" + " " + lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }

    static int lcs(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }
}

