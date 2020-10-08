/**
 * Inversions
 */
public class Inversions {

  // Return the number of inversions in the permutation a[].
  public static long count(int[] a) {
    long cnt = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i] > a[j])
          cnt++;
      }
    }

    return cnt;
  }

  // Return permutation of length n with exactly k inversions
  public static int[] generate(int n, long k) {
    int[] a = new int[n];
    int j = n - 1;
    int p = 0; // index for invers placing
    int q = n - 1; // index for normal placing
    while (k >= 0 && j >= 0) {
      if (k >= j) {
        a[p] = j;
        k -= j;
        p++;
      } else {
        a[q] = j;
        q--;
      }
      j--;
    }

    return a;
  }

  // Takes an integer n and a long k as command-line arguments
  // and prints a permutation of length n with exactly k inversions.
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
 
    int[] a = generate(n, k);
 
    for (int i = 0; i < n; i++) {
      StdOut.print(a[i] + " ");
    }
  }
}

