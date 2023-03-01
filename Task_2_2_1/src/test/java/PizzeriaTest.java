import JsonReader.GsonParser;
import JsonReader.JsonValues;
import org.junit.jupiter.api.Test;

public class PizzeriaTest {
  @Test
  public void PizzeriaWorkingTest(){
    GsonParser jsonFile = new GsonParser();
    JsonValues values = jsonFile.parse();
    Pizzeria pizzeria = new Pizzeria(values);
    final int time = 30000;
    pizzeria.running(time);
  }
}
