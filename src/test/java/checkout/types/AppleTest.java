package checkout.types;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.math.BigDecimal;

public class AppleTest {
   @Test
   public void testInstantiateApple() {
      Assertions.assertEquals("0.60", new Apple().getPrice().toPlainString(), "an apple should have a price of 60p");
   }

   @Test
   public void testFactoryCreateApple() {
      Item item = Item.getItem("APPLE");
      System.out.println(item);
      Assertions.assertTrue(item instanceof Apple, "passing APPLE to getItem should create an Apple object");
   }
}
