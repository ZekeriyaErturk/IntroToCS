/** ShannonEntropy */
public class ShannonEntropy {
  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);

    double[] nums = new double[m];
    double[] p = new double[m];
    double numberOfInput = 0;
    double entropi = 0.0;
    double log2 = 0.0;

    // Get the data
    while (!StdIn.isEmpty()) {
      int n = StdIn.readInt();
      nums[n - 1]++;
      numberOfInput++;
    }

    // calc p
    for (int i = 0; i < nums.length; i++) {
      p[i] = nums[i] / numberOfInput;
    }

    for (int i = 0; i < m; i++) {
      if (p[i] != 0) log2 = (Math.log(p[i]) / Math.log(2));
      entropi -= (p[i] * log2);
    }

    StdOut.printf("%.4f\n", entropi);
  }
}
