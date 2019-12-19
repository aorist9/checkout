package checkout.types;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class OrangeTest {
   @Test
   public void testInstantiate() {
      Assertions.assertEquals("0.25", new Orange().getPrice().toPlainString(), "Orange should have price of 25p");
   }

   @Test
   public void testFactoryCreation() {
      Assertions.assertTrue(Item.getItem("OrAngE") instanceof Orange, "factory method should return an Orange for any case of orange");
   }
}
