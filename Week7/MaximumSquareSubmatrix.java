/**
 * MaximumSquareSubmatrix
 */
public class MaximumSquareSubmatrix {
  // Returns the size of the largest contiguous square submatrix
  // of a[][] containing only 1s.
  public static int size(int[][] a) {
    int n = a.length;
    int size = 0;
    int[][] c = new int[n + 2][n + 2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 0)
          c[i + 1][j + 1] = 0;
        else
          c[i + 1][j + 1] = Math.min(c[i][j], Math.min(c[i + 1][j], c[i][j + 1])) + 1;
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (c[i][j] > size)
          size = c[i][j];
      }
    }

    return size;
  }

  // Reads an n-by-n matrix of 0s and 1s from standard input
  // and prints the size of the largest contiguous square submatrix
  // containing only 1s.
  public static void main(String[] args) {
    int n = StdIn.readInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = StdIn.readInt();
      }
    }

    StdOut.println(size(a));

  }
}
