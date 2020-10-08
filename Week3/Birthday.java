/** Birthday */
public class Birthday {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);
    int[] counter = new int[n + 2];

    for (int i = 0; i < trials; i++) {
      int people = 0;
      boolean[] bdays = new boolean[n];
      for (int j = 0; j < n; j++) {
        people++;
        int birthday = (int) (Math.random() * n);

        if (bdays[birthday]) break;
        else bdays[birthday] = true;
      }
      counter[people]++;
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += counter[i + 1];

      System.out.println((i + 1) + "\t" + counter[i + 1] + "\t" + (1.0 * sum / trials * 1.0));
      if ((1.0 * sum / trials) >= 0.5) {
        break;
      }
    }
  }
}
