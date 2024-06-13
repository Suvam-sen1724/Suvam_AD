/*
Pseudo-code:
BruteForceSearch(text T, pattern P):
  n = length(T)
  m = length(P)
  for i from 0 to n-m do:
    j = 0
    while j < m and T[i+j] == P[j] do:
      j = j + 1
    if j == m return i
  return not found

*/

//Code:
package Hash_Table;

class BruteForceSearch {
    static int search(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M)
                return i;
        }

        return -1;
    }
}

public class BruteForce {
    public static void main(String[] args) {
        // input
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        // output
        int result = BruteForceSearch.search(txt, pat);
        System.out.println("Pattern found at index: " + result);

    }
}
