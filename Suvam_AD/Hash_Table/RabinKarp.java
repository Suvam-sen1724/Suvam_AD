/*
Pseudo-code:
RabinKarp(text T, pattern P):
  n = length(T)
  m = length(P)
  hP = hash(P[0, ..., m-1])
  hT = hash(T[0, ..., m-1])
  for i from 0 to n-m do:
    if hP == hT:
      if T[i, ..., i+m-1] == P[0, ..., m-1]:
        return i
    hT = hash(T[i+1, ..., i+m])
  return not found

*/

//Code:
package Hash_Table;

class RabinKarpAlgorithm {
    public final static int d = 256;

    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (i = 0; i <= N - M; i++) {
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0)
                    t = (t + q);
            }
        }
    }
}

public class RabinKarp {
    public static void main(String[] args) {
        // input
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        int q = 101;

        // output
        RabinKarpAlgorithm.search(pat, txt, q);

    }
}
