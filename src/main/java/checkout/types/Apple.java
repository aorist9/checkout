package checkout.types;

import java.math.BigDecimal;

import checkout.types.Item;

public class Apple extends Item {
   @Override
   public BigDecimal getPrice() {
      return new BigDecimal("0.60");
   }
}
