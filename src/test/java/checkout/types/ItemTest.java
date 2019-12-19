package checkout.types;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.math.BigDecimal;

public class ItemTest {
   @Test
   public void testRegistryNoMatch() {
      Assertions.assertNull(Item.getItem("anything"), "nothing is registered, so the test should return null");
   }
}
