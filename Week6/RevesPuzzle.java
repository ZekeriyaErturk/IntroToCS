/**
 * RevesPuzzle
 */
public class RevesPuzzle {
  private static void solve3(int n, int k, String from, String temp, String to) {
    if (n <= k)
      return;
    solve3(n - 1, k, from, to, temp);
    StdOut.println("Move disc " + n + " from " + from + " to " + to);
    solve3(n - 1, k, temp, from, to);

  }

  private static void solve4(int n, String from, String temp1, String temp2, String to) {
    int k = (int) Math.round((n + 1) - Math.sqrt((2 * n) + 1));

    if (n == 0)
      return;

    solve4(k, from, to, temp2, temp1);
    solve3(n, k, from, temp2, to);
    solve4(k, temp1, from, temp2, to);
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    solve4(n, "A", "B", "C", "D");
  }

}
