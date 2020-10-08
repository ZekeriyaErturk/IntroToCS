/** AudioCollage */
public class AudioCollage {
  // Returns a new array that rescales a[] by a multiplicative factor alpha
  public static double[] amplify(double[] a, double alpha) {
    int m = a.length;
    double b[] = new double[m];
    for (int i = 0; i < m; i++) {
      b[i] = a[i] * alpha;
    }
    return b;
  }

  // Returns a new array that is the reverse of a[]
  public static double[] reverse(double[] a) {
    int m = a.length;
    double b[] = new double[m];
    for (int i = 0; i < m; i++) {
      b[i] = a[m - 1 - i];
    }
    return b;
  }

  // Returns a new array that is the concatenation of a[] and b[].
  public static double[] merge(double[] a, double[] b) {
    int m = a.length;
    int n = b.length;
    double[] c = new double[m + n];
    for (int i = 0; i < m + n; i++) {
      if (i < m)
        c[i] = a[i];
      else
        c[i] = b[i - m];
    }
    return c;
  }

  // Returns a new array that is the sum of a[] and b[],
  // padding the shorter arrays with trailing 0s if necessary.
  public static double[] mix(double[] a, double[] b) {
    int m = a.length;
    int n = b.length;
    if (m > n) {
      double[] c = new double[m];
      for (int i = 0; i < n; i++) {
        c[i] = b[i];
      }
      for (int i = 0; i < m; i++) {
        c[i] += a[i];
      }
      return c;
    } else {
      double[] c = new double[n];
      for (int i = 0; i < m; i++) {
        c[i] = a[i];
      }
      for (int i = 0; i < n; i++) {
        c[i] += b[i];
      }
      return c;
    }
  }

  // Returns a new array that changes the speed by the given factor.
  public static double[] changeSpeed(double[] a, double alpha) {
    int m = a.length;
    int n = (int) (m / alpha);
    double[] b = new double[n];
    for (int i = 0; i < n; i++) {
      int s = (int) (i * alpha);
      b[i] = a[s];
    }
    return b;
  }

  public static void main(String[] args) {
    double duration = StdRandom.uniform(50) + 10;
    int hz = 440;
    int N = (int) (StdAudio.SAMPLE_RATE * duration);
    double[] remix = new double[N + 1];
    for (int i = 0; i < N; i++) {
      remix[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
    }

    StdAudio.play(remix);
  }
}
