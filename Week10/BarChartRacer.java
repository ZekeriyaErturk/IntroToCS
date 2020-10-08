
/**
 * BarChartRacer
 */

import java.util.Arrays;

public class BarChartRacer {
  public static void main(String[] args) {
    StdDraw.enableDoubleBuffering();
    StdDraw.setCanvasSize(1000, 700);
    In file = new In(args[0]);
    int k = Integer.parseInt(args[1]);
    String title = file.readLine();
    String xAxisLabel = file.readLine();
    String source = file.readLine();
    BarChart chart = new BarChart(title, xAxisLabel, source);

    while (file.hasNextLine()) {
      file.readLine();
      int group = Integer.parseInt(file.readLine());
      Bar[] bars = new Bar[group];
      for (int i = 0; i < group; i++) {
        String line = file.readLine();
        String[] data = line.split(",");
        bars[i] = new Bar(data[1], Integer.parseInt(data[3]), data[4]);
        chart.setCaption(data[0]);
      }
      Arrays.sort(bars);

      for (int i = group - 1; i >= group - k; i--) {
        chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
      }
      StdDraw.clear();
      chart.draw();
      StdDraw.show();
      StdDraw.pause(50);
      chart.reset();
    }
  }
}
