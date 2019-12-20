package checkout.types;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.LinkedList;
import java.math.BigDecimal;

import checkout.deals.XForYDeal;

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

   @Test
   public void testWithPreprocessing() {
      Cart processedCart = new Cart(
         items -> {
            List<Item> result = new LinkedList<>();
            Orange firstOrange = null;
            Orange secondOrange = null;
            for (Item item : items) {
               if (item instanceof Orange) {
                  if (firstOrange == null) {
                     firstOrange = (Orange) item;
                  } else if (secondOrange == null) {
                     secondOrange = (Orange) item;
                  } else {
                     result.add(
                        new XForYDeal<Orange>(2,
                           firstOrange,
                           secondOrange,
                           (Orange) item
                        )
                     );
                     firstOrange = null;
                     secondOrange = null;
                  }
               } else {
                  result.add(item);
               }
            }

            if (firstOrange != null) {
               result.add(firstOrange);
               if (secondOrange != null) {
                  result.add(secondOrange);
               }
            }
            return result;
         },
         items -> {
            List<Item> result = new LinkedList<>();
            for (Item item : items) {
               if (!(item instanceof Apple)) {
                  result.add(item);
               }
            }
            return result;
         }
      );
      processedCart.addItem(new Orange());
      processedCart.addItem(new Apple());
      processedCart.addItem(new Orange());
      processedCart.addItem(new Orange());
      processedCart.addItem(new Apple());
      processedCart.addItem(new Orange());

      Assertions.assertEquals("0.75", processedCart.getTotal().toPlainString(),
         "Apples should be removed and three of the oranges should be sold for the price of two");
   }
}
