/**
 * ColorHSB
 */
public class ColorHSB {
  private final int h0;
  private final int s0;
  private final int b0;

  // Creates a color with hue h, saturation s, and brightness b.
  public ColorHSB(int h, int s, int b) {
    if (!(h >= 0 && h <= 359))
      throw new IllegalArgumentException("The hue must be between 0 and 359");
    if (!(s >= 0 && s <= 100))
      throw new IllegalArgumentException("The saturation must be between 0 and 100");
    if (!(b >= 0 && b <= 100))
      throw new IllegalArgumentException("The brightness must be between 0 and 100");

    this.h0 = h;
    this.s0 = s;
    this.b0 = b;
  }

  // Returns a string representation of this color, using the format(h, s, b)
  public String toString() {
    return "(" + h0 + ", " + s0 + ", " + b0 + ")";
  }

  // Is this color a shade of gray?
  public boolean isGrayscale() {
    return (s0 == 0) || (b0 == 0);
  }

  // Returns the squared distance between the two colors.
  public int distanceSquaredTo(ColorHSB that) {
    return Math.round(Math.min((this.h0 - that.h0) * (this.h0 - that.h0),
        (360 - Math.abs(this.h0 - that.h0)) * (360 - Math.abs(this.h0 - that.h0)))
        + (this.s0 - that.s0) * (this.s0 - that.s0) + (this.b0 - that.b0) * (this.b0 - that.b0));
  }

  public static void main(String[] args) {
    int h1 = Integer.parseInt(args[0]);
    int s1 = Integer.parseInt(args[1]);
    int b1 = Integer.parseInt(args[2]);
    ColorHSB x = new ColorHSB(h1, s1, b1);
    x.isGrayscale();
    String colorName = null;
    ColorHSB closestColor = null;
    double closest = Double.POSITIVE_INFINITY;
    while (!StdIn.isEmpty()) {
      String name = StdIn.readString();
      int h2 = StdIn.readInt();
      int s2 = StdIn.readInt();
      int b2 = StdIn.readInt();
      ColorHSB y = new ColorHSB(h2, s2, b2);
      if (x.distanceSquaredTo(y) < closest) {
        colorName = name;
        closestColor = y;
        closest = x.distanceSquaredTo(y);
      }
    }

    StdOut.println(colorName + " " + closestColor);
  }
}
