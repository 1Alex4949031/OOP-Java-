package nsu.seleznev.a;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;


/**
 * Chart implementation based on ComplexTimeTest.
 * You can easily change some variables for complex test.
 * Check ComplexTimeTest
 */
public class BarChart extends ApplicationFrame {

  private static final long serialVersionUID = 1L;

  static {
    ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow", true));
  }

  /**
   * BarChart constructor.
   *
   * @param title title of the chart
   */
  public BarChart(String title) {
    super(title);
    setContentPane(createPanel());
  }

  /**
   * Function that creates UI Panel for the Chart.
   *
   * @return JPanel for the Chart
   */
  public JPanel createPanel() {
    CategoryDataset dataset = createDataset();
    JFreeChart chart = createChart(dataset);
    chart.setPadding(new RectangleInsets(4, 8, 2, 2));
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setFillZoomRectangle(true);
    chartPanel.setMouseWheelEnabled(true);
    chartPanel.setPreferredSize(new Dimension(500, 270));
    return chartPanel;
  }

  /**
   * Function that creates the dataset for the Chart.
   *
   * @return CategoryDataset
   */
  private CategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(3996, "Последовательно", "Последовательно");
    dataset.addValue(3921, "Параллельно", "1");
    dataset.addValue(2156, "Параллельно", "2");
    dataset.addValue(1595, "Параллельно", "3");
    dataset.addValue(1400, "Параллельно", "4");
    dataset.addValue(1114, "Параллельно", "5");
    dataset.addValue(1083, "Параллельно", "6");
    dataset.addValue(915, "Параллельно", "7");
    dataset.addValue(814, "Параллельно", "8");
    dataset.addValue(750, "Параллельно", "9");
    dataset.addValue(715, "Параллельно", "10");
    dataset.addValue(651, "Параллельно", "11");
    dataset.addValue(626, "Параллельно", "12");
    dataset.addValue(590, "Параллельно", "13");
    dataset.addValue(588, "Параллельно", "14");
    dataset.addValue(586, "Параллельно", "15");
    dataset.addValue(556, "Параллельно", "16");
    dataset.addValue(557, "Parallels Stream", "Parallel Stream Api");
    return dataset;
  }

  /**
   * Function that creates Chart.
   *
   * @param dataset dataset made
   * @return JFreeChart
   */
  private JFreeChart createChart(CategoryDataset dataset) {
    JFreeChart chart = ChartFactory.createBarChart(
        "Многопоточность",
        null,
        "Время в миллисекундах",
        dataset);
    chart.addSubtitle(new TextTitle("Сравнение времени работы по кол-ву потоков"
        + " поиска не простого числа в массиве"));
    chart.setBackgroundPaint(Color.white);
    CategoryPlot plot = (CategoryPlot) chart.getPlot();

    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setDrawBarOutline(false);
    chart.getLegend().setFrame(BlockBorder.NONE);
    return chart;
  }

  /**
   * Main function that portrays the Chart.
   */
  public static void main(String[] args) {
    BarChart chart = new BarChart("Многопоточность: Chart.java");
    chart.pack();
    RefineryUtilities.centerFrameOnScreen(chart);
    chart.setVisible(true);
  }
}