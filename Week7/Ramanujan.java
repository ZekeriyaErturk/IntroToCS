/**
 * Ramanujan
 */
public class Ramanujan {

  // Is n a Ramanujan number?
  public static boolean isRamanujan(long n) {
    int check = 0;
    long a = 1;
    long b = 1;
    long c = 1;
    long d = 1;

    while (a < Math.cbrt(n)) {
      b = Math.round(Math.cbrt(n - (a * a * a)));
      if ((a * a * a) + (b * b * b) == n) {
        check++;
        break;
      }
      a++;
    }

    while (c < Math.cbrt(n)) {
      d = Math.round(Math.cbrt(n - (c * c * c)));
      if ((a != c && b != d) && (c * c * c) + (d * d * d) == n) {
        check++;
        break;
      }
      c++;
    }

    if (check == 2)
      return true;
    else
      return false;
  }

  // Takes a long integer command-line arguments n and prints true
  // if n is Ramanujan number, and false otherwise.
  public static void main(String[] args) {
    long n = Long.parseLong(args[0]);

    StdOut.println(isRamanujan(n));
  }
}
