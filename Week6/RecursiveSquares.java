/**
 * RecursiveSquares
 */
public class RecursiveSquares {

  // Draws a square centered on (x, y) of the given side length
  // with a light gray background and a black border.
  public static void drawSquare(double x, double y, double length) {
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
    StdDraw.filledSquare(x, y, length);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.square(x, y, length);
  }

  // Draws a recursive square pattern of order n, centered on (x, y)
  // of the given side length
  public static void draw(int n, double x, double y, double length) {
    if (n == 0)
      return;

    length = length / 2.0;

    double x1 = x + length;
    double x0 = x - length;
    double y1 = y + length;
    double y0 = y - length;

    draw(n - 1, x0, y1, length);
    draw(n - 1, x1, y1, length);
    drawSquare(x, y, length);
    draw(n - 1, x0, y0, length);
    draw(n - 1, x1, y0, length);
  }

  // Takes integer command-line argument n and draws a recursive
  // square pattern of order n, centerd on (0.5, 0.5) width side length 0.5.
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    double x = 0.5, y = 0.5, length = 0.5;

    draw(n, x, y, length);
  }
}
