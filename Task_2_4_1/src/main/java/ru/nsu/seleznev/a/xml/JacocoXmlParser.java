package ru.nsu.seleznev.a.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import ru.nsu.seleznev.a.html.HtmlTableBuilder;

/**
 * Jacoco xml parser.
 */
public class JacocoXmlParser {
  private static final List<String> headerParams =
      Arrays.asList("name", "tests", "skipped", "failures",
          "errors", "timestamp", "hostname", "time");
  private static final List<String> bodyParams =
      Arrays.asList("name", "classname", "time");

  /**
   * Function that parses the xml file.
   * I want to mention that this public method is made for building html report.
   *
   * @param file file need to be parsed
   * @return string value of parsed file
   */
  public static String parseXml(File file) {
    try {
      List<String> values = new ArrayList<>();
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(file);
      document.getDocumentElement().normalize();
      NamedNodeMap rootNode = document.getDocumentElement().getAttributes();
      for (var p : headerParams) {
        values.add(rootNode.getNamedItem(p).getNodeValue());
      }
      HtmlTableBuilder tableBuilder = new HtmlTableBuilder(null, true);
      tableBuilder.addTableHeader(headerParams);
      tableBuilder.addRowValues(values);
      values.clear();
      tableBuilder.addTableHeader(bodyParams);
      NodeList testcaseNodes = document.getElementsByTagName("testcase");
      for (int i = 0; i < testcaseNodes.getLength(); i++) {
        for (var p : bodyParams) {
          values.add(testcaseNodes.item(i).getAttributes().getNamedItem(p).getNodeValue());
        }
        tableBuilder.addRowValues(values);
        values.clear();
      }
      return tableBuilder.build();
    } catch (Exception e) {
      throw new RuntimeException("Something goes wrong with xml file parsing!");
    }
  }
}
