import JsonReader.JsonCook;
import JsonReader.JsonCourier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * JsonCourier tests
 */
public class JsonCourierTest {
  @Test
  public void getNameTest() {
    JsonCourier cook = new JsonCourier("Alex", 2, 3);
    String act = cook.getName();
    String exp = "Alex";
    Assertions.assertEquals(act, exp);
  }

  @Test
  public void getDeliveryTimeTest() {
    JsonCourier cook = new JsonCourier("Alex", 2, 3);
    int act = cook.getDeliveryExperience();
    int exp = 2;
    Assertions.assertEquals(act, exp);
  }

  @Test
  public void getDeliverySize() {
    JsonCourier cook = new JsonCourier("Alex", 2, 3);
    int act = cook.getDeliverySize();
    int exp = 3;
    Assertions.assertEquals(act, exp);
  }

  @Test
  public void equalsTest() {
    JsonCourier act = new JsonCourier("Alex", 2, 10);
    JsonCourier exp = new JsonCourier("Alex", 2, 10);

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void equalsHashCodeTest() {
    JsonCourier act = new JsonCourier("Alex", 2, 10);
    JsonCourier exp = new JsonCourier("Alex", 2, 10);

    Assertions.assertEquals(exp.hashCode(), act.hashCode());
  }
}
