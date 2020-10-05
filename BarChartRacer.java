
import java.util.Arrays;
import java.util.Comparator;

public class BarChartRacer {
    public static void main(String[] args) {

        In in = new In(args[0]);
        int k = Integer.parseInt(args[1]);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();

        BarChart chart = new BarChart(title, xAxis, source);

        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);

        while (in.hasNextLine()) {

            in.readLine();

            int n = Integer.parseInt(in.readLine());

            // create array of bars using data and sort them
            Bar[] bars = new Bar[n];

            for (int i = 0; i < n; i++) {

                String entry = in.readLine();
                String[] data = entry.split(",");
                bars[i] = new Bar(data[1], Integer.parseInt(data[3]), data[4]);

                chart.setCaption(data[0]);
            }
            Arrays.sort(bars, Comparator.reverseOrder());

            // add the bars to the bar chart
            for (int i = 0; i < k; i++) {
                String name = bars[i].getName();
                int value = bars[i].getValue();
                String category = bars[i].getCategory();
                chart.add(name, value, category);
            }

            // draw the bar chart
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(10);
            chart.reset();
        }
    }
}
