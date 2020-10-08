/** DiscreteDistribution */
public class DiscreteDistribution {
  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);
    int[] a = new int[args.length - 1];
    int[] s = new int[args.length];

    for (int i = 0; i < a.length; i++) {
      a[i] = Integer.parseInt(args[i + 1]);
    }

    for (int i = 1; i < s.length; i++) {
      s[i] = a[i - 1] + s[i - 1];
    }

    for (int i = 0; i < m; i++) {
      int r = (int) (Math.random() * s[s.length - 1]);
      for (int j = 1; j < s.length; j++) {
        if (s[j - 1] <= r && r < s[j]) System.out.print(j + " ");
      }
      if (i % 25 == 24) System.out.println();
    }
  }
}
