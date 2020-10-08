/**
 * TrinomialDP
 */
public class TrinomialDP {

  // Returns the trinomial coefficient T(n, k).
  public static long trinomial(int n, int k) {
    if (k > n || k < -n)
      return 0;
    k = Math.abs(k);
    long[][] c = new long[n + 2][n + 2];
    c[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (j > i)
          continue;
        c[i][j] = c[i - 1][Math.abs(j - 1)] + c[i - 1][j] + c[i - 1][j + 1];
      }
    }

    return c[n][k];
  }

  // Takes two integer command-line arguments n and k and prints T(n, k).
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
    StdOut.println(trinomial(n, k));
  }

}
