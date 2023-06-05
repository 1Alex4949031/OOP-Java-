package ru.nsu.seleznev.a.html;


import java.util.List;

/**
 * Uses:
 * HTMLTableBuilder htmlBuilder = new HTMLTableBuilder(null, true, 2, 3);
 * htmlBuilder.addTableHeader("1H", "2H", "3H");
 * htmlBuilder.addRowValues("1", "2", "3");
 * htmlBuilder.addRowValues("4", "5", "6");
 * htmlBuilder.addRowValues("9", "8", "7");
 * String table = htmlBuilder.build();
 * System.out.println(table.toString());
 */
public class HTMLTableBuilder {
  private final StringBuilder table = new StringBuilder();
  public static String HTML_START = "<html>";
  public static String HTML_END = "</html>";
  public static String TABLE_START_BORDER = "<table border=\"3\">";
  public static String TABLE_START = "<table>";
  public static String TABLE_END = "</table>";
  public static String HEADER_START = "<th>";
  public static String HEADER_END = "</th>";
  public static String ROW_START = "<tr>";
  public static String ROW_END = "</tr>";
  public static String COLUMN_START = "<td>";
  public static String COLUMN_END = "</td>";


  /**
   * Html table builder constructor.
   *
   * @param header header
   * @param border border
   */
  public HTMLTableBuilder(String header, boolean border) {
    if (header != null) {
      table.append("<b>");
      table.append(header);
      table.append("</b>");
    }
    table.append(HTML_START);
    table.append(border ? TABLE_START_BORDER : TABLE_START);
    table.append(TABLE_END);
    table.append(HTML_END);
  }


  /**
   * Function that adds table headers.
   *
   * @param values list with values
   */
  public void addTableHeader(List<String> values) {
    int lastIndex = table.lastIndexOf(TABLE_END);
    if (lastIndex > 0) {
      StringBuilder sb = new StringBuilder();
      sb.append(ROW_START);
      for (String value : values) {
        sb.append(HEADER_START);
        sb.append(value);
        sb.append(HEADER_END);
      }
      sb.append(ROW_END);
      table.insert(lastIndex, sb);
    }
  }

  /**
   * Function that adds table headers.
   *
   * @param values string values
   */
  public void addTableHeader(String... values) {
    int lastIndex = table.lastIndexOf(TABLE_END);
    if (lastIndex > 0) {
      StringBuilder sb = new StringBuilder();
      sb.append(ROW_START);
      for (String value : values) {
        sb.append(HEADER_START);
        sb.append(value);
        sb.append(HEADER_END);
      }
      sb.append(ROW_END);
      table.insert(lastIndex, sb);
    }
  }


  /**
   * Function that adds row values.
   *
   * @param values list with values
   */
  public void addRowValues(List<String> values) {
    int lastIndex = table.lastIndexOf(ROW_END);
    if (lastIndex > 0) {
      int index = lastIndex + ROW_END.length();
      StringBuilder sb = new StringBuilder();
      sb.append(ROW_START);
      for (String value : values) {
        sb.append(COLUMN_START);
        sb.append(value);
        sb.append(COLUMN_END);
      }
      sb.append(ROW_END);
      table.insert(index, sb);
    }
  }

  /**
   * Function that adds row values.
   *
   * @param values string values
   */
  public void addRowValues(String... values) {
    int lastIndex = table.lastIndexOf(ROW_END);
    if (lastIndex > 0) {
      int index = lastIndex + ROW_END.length();
      StringBuilder sb = new StringBuilder();
      sb.append(ROW_START);
      for (String value : values) {
        sb.append(COLUMN_START);
        sb.append(value);
        sb.append(COLUMN_END);
      }
      sb.append(ROW_END);
      table.insert(index, sb);
    }
  }


  /**
   * Function that build html table.
   *
   * @return string html table
   */
  public String build() {
    return table.toString();
  }
}
