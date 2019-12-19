package checkout.types;

import java.math.BigDecimal;

/**
 * Orange - an object representing an Orange as an item to be purchased
 */
public class Orange extends Item {
   @Override
   public BigDecimal getPrice() {
      return new BigDecimal("0.25");
   }
}
