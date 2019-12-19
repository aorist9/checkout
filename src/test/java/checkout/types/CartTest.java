package checkout.types;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.math.BigDecimal;

public class CartTest {
   private Cart cart;

   @BeforeEach
   public void setup() {
      this.cart = new Cart();
      this.cart.addItem(new Apple());
      this.cart.addItem(new Orange());
      this.cart.addItem(new Apple());
   }

   @Test
   public void testGetItems() {
      Assertions.assertEquals(3, this.cart.getItems().size(), "cart should have 3 items");
   }

   @Test
   public void testGetTotal() {
      Assertions.assertEquals("1.45", this.cart.getTotal().toPlainString(), "items should total 1.45");
   }

   @Test
   public void testTotalForEmptyList() {
      Assertions.assertEquals(BigDecimal.ZERO, new Cart().getTotal(), "an empty cart should have a total of 0");
   }
}
