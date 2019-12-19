package checkout.types;

import java.math.BigDecimal;

public class Orange extends Item {
   @Override
   public BigDecimal getPrice() {
      return new BigDecimal("0.25");
   }
}
