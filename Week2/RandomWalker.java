/** RandomWalker */
public class RandomWalker {
  public static void main(String[] args) {
    int r = Integer.parseInt(args[0]);
    int x0 = 0;
    int y0 = 0;
    int x1 = 0;
    int y1 = 0;
    int steps = 0;

    System.out.println("(" + x1 + "," + y1 + ")");
    while (Math.abs(x0 - x1) + Math.abs(y0 - y1) != r) {
      int direction = (int) (Math.random() * 4);

      if (direction == 0) y1++;
      else if (direction == 1) y1--;
      else if (direction == 2) x1++;
      else if (direction == 3) x1--;

      System.out.println("(" + x1 + "," + y1 + ")");
      steps++;
    }

    System.out.println("steps = " + steps);
  }
}
