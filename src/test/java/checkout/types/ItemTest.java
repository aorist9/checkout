import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.math.BigDecimal;

import checkout.types.Item;

public class ItemTest {
   @Test
   public void testRegistryNoMatch() {
      Assertions.assertNull(Item.getItem("anything"), "nothing is registered, so the test should return null");
   }

   @Test
   public void testRegistryMatch() {
      Item.registerItem("item", () -> new Item() {
         @Override
	 public BigDecimal getPrice() {
            return BigDecimal.ONE;
	 }
      });
      Assertions.assertEquals(BigDecimal.ONE, Item.getItem("item").getPrice(), "get item should return the item that was created, which should have a price of 1");
   }
}
