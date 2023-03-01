import JsonReader.GsonParser;
import JsonReader.JsonValues;

/**
 * PizzeriaMain class that starts the work of the Pizzeria "BIG J".
 */
public class PizzeriaMain {
  public static void main(String[] args) {
    GsonParser jsonFile = new GsonParser();
    JsonValues values = jsonFile.parse();
    Pizzeria pizzeria = new Pizzeria(values);
    final int time = 30000;
    pizzeria.running(time);
  }
}
