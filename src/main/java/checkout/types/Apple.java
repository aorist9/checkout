package checkout.types;

import java.math.BigDecimal;

import checkout.types.Item;

/**
 * Apple - an object representing an Apple as an item to be purchased
 */
public class Apple extends Item {
   @Override
   public BigDecimal getPrice() {
      return new BigDecimal("0.60");
   }
}
