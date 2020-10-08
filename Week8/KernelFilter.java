
/**
 * KernelFilter
 */
import java.awt.Color;

public class KernelFilter {

  // Returns a new picture that applies the identity filter to the given picture.
  public static Picture identity(Picture picture) {
    double[][] filter = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
    return kernel(picture, filter);
  }

  // Returns a new picture that applies a Gaussian blur filter to the given
  // picture.
  public static Picture gaussian(Picture picture) {
    double[][] filter = { { 1.0 / 16.0, 2.0 / 16.0, 1.0 / 16.0 }, { 2.0 / 16.0, 4.0 / 16.0, 2.0 / 16.0 },
        { 1.0 / 16.0, 2.0 / 16.0, 1 / 16.0 } };
    return kernel(picture, filter);
  }

  // Returns a new picture that applies a sharpen filter to the given picture.
  public static Picture sharpen(Picture picture) {
    double[][] filter = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
    return kernel(picture, filter);
  }

  // Returns a new picture that applies a Laplacian filter to the given picture.
  public static Picture laplacian(Picture picture) {
    double[][] filter = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };
    return kernel(picture, filter);
  }

  // Returns a new picture that applies an emboss filter to the given picture.
  public static Picture emboss(Picture picture) {
    double[][] filter = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };
    return kernel(picture, filter);
  }

  // Returns a new picture that applies a motion blur filter to the given picture.
  public static Picture motionBlur(Picture picture) {
    double[][] filter = { { 1.0 / 9.0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1.0 / 9.0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 1.0 / 9.0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1.0 / 9.0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 1.0 / 9.0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1.0 / 9.0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 1.0 / 9.0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1.0 / 9.0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 1.0 / 9.0 } };
    return kernel(picture, filter);
  }

  // Returns a new picture that applies an arbitrary kernel filter to the given
  // picture
  private static Picture kernel(Picture picture, double[][] filter) {
    int width = picture.width();
    int height = picture.height();
    Picture copy = new Picture(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        double red = 0.0, green = 0.0, blue = 0.0;
        for (int k = 0; k < filter.length; k++) {
          for (int p = 0; p < filter[0].length; p++) {
            int x0 = i - filter.length / 2 + k;
            int y0 = j - filter[0].length / 2 + p;
            if (x0 < 0)
              x0 = Math.floorMod(x0, width);
            if (y0 < 0)
              y0 = Math.floorMod(y0, height);
            if (x0 >= width)
              x0 = Math.floorMod(x0, width);
            if (y0 >= height)
              y0 = Math.floorMod(y0, height);

            red += filter[k][p] * picture.get(x0, y0).getRed();
            green += filter[k][p] * picture.get(x0, y0).getGreen();
            blue += filter[k][p] * picture.get(x0, y0).getBlue();
          }
        }
        if (red > 255)
          red = 255;
        if (green > 255)
          green = 255;
        if (blue > 255)
          blue = 255;
        if (red < 0)
          red = 0;
        if (green < 0)
          green = 0;
        if (blue < 0)
          blue = 0;
        copy.set(i, j, new Color((int) Math.round(red), (int) Math.round(green), (int) Math.round(blue)));
      }
    }
    return copy;
  }

  // Test client (ungraded).
  public static void main(String[] args) {
    Picture pic = new Picture(args[0]);

    Picture identity = identity(pic);
    Picture gaussian = gaussian(pic);
    Picture laplacian = laplacian(pic);
    Picture sharpen = sharpen(pic);
    Picture emboss = emboss(pic);
    Picture motionBlur = motionBlur(pic);
    identity.show();
    gaussian.show();
    laplacian.show();
    sharpen.show();
    emboss.show();
    motionBlur.show();
  }
}
