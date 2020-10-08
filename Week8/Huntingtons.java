/**
 * Huntingtons
 */
public class Huntingtons {

  // Returns the maximum number of consecutive repeats of CAG in the DNA string.
  public static int maxRepeats(String dna) {
    int maxCount = 0;
    int count = 0;
    int n = dna.length();
    byte[] memo = new byte[n];
    for (int i = 0; i < n - 2; i++) {
      if (dna.substring(i, i + 3).equals("CAG")) {
        memo[i] = 1;
        memo[i + 1] = 1;
        memo[i + 2] = 1;
      }
    }

    for (int i = 0; i < n; i++) {
      if (memo[i] == 1) {
        count++;
        if (count / 3 > maxCount) {
          maxCount = count / 3;
        }
      } else {
        count = 0;
      }
    }

    return maxCount;
  }

  // Returns a copy of s, with all whitespace(spaces, tabs, and newlines) removed.
  public static String removeWhitespace(String s) {
    String r = new String(s);
    r = r.replace(" ", "");
    r = r.replace("\t", "");
    r = r.replace("\n", "");
    return r;
  }

  // Returns one of these diagnoses corresponding to the maximum number of
  // repeats:
  // "not human", "normal", "high risk", or "Huntington's"
  public static String diagnose(int maxRepeats) {
    if (maxRepeats >= 0 && maxRepeats <= 9)
      return "not human";
    else if (maxRepeats >= 10 && maxRepeats <= 35)
      return "normal";
    else if (maxRepeats >= 36 && maxRepeats <= 39)
      return "high risk";
    else if (maxRepeats >= 40 && maxRepeats <= 180)
      return "Huntington's";
    else
      return "not human";
  }

  // Sample client (see below)
  public static void main(String[] args) {
    String file = args[0];
    In in = new In(file);

    String dna = in.readAll();
    dna = removeWhitespace(dna);
    int maxRepeats = maxRepeats(dna);
    String diagnose = diagnose(maxRepeats);

    StdOut.println("max repeats = " + maxRepeats);
    StdOut.println(diagnose);
  }
}
