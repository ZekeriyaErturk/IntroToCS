/** Divisors */
public class Divisors {
  // Returns the greatest common divisor of a and b
  public static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    while (b != 0) {
      int temp = a;
      a = b;
      b = temp % b;
    }
    return a;
  }

  // Returns the least common multiple of a and b
  public static int lcm(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    if (a == 0 || b == 0)
      return 0;
    return (a / gcd(a, b)) * b;
  }

  // Returns true if a and b are relatively prime; false otherwise
  public static boolean areRelativelyPrime(int a, int b) {
    if (gcd(a, b) == 1)
      return true;
    return false;
  }

  // Returns the number of integers between 1 and n that are relatively prime
  // with n
  public static int totient(int n) {
    int rPrimes = 0;
    for (int i = 1; i <= n; i++) {
      if (areRelativelyPrime(i, n))
        rPrimes++;
    }

    return rPrimes;
  }

  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);

    StdOut.println("gcd(" + a + "," + b + ") = " + gcd(a, b));
    StdOut.println("lcm(" + a + "," + b + ") = " + lcm(a, b));
    StdOut.println("areRelativelyPrime(" + a + "," + b + ") = " + areRelativelyPrime(a, b));
    StdOut.println("totient(" + a + ") = " + totient(a));
    StdOut.println("totient(" + b + ") = " + totient(b));
  }
}
