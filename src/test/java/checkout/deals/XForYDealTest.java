package checkout.deals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import checkout.types.Orange;
import checkout.types.Apple;

public class XForYDealTest {
   @Test
   public void testTwoForOneOranges() {
      Assertions.assertEquals("0.25",
         new XForYDeal<Orange>(1,
            new Orange(),
            new Orange()
         ).getPrice().toPlainString(),
	 "Two for one on Oranges should cost 25p");
   }

   @Test
   public void testThreeForTwoApples() {
      Assertions.assertEquals("1.20",
         new XForYDeal<Apple>(2,
            new Apple(),
            new Apple(),
            new Apple()
         ).getPrice().toPlainString(),
      "Three for two on Apples should be 1.20");
   }
}
