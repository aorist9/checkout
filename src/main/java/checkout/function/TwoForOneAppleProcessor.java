package checkout.function;

import java.util.List;
import java.util.LinkedList;
import java.util.function.Function;

import checkout.types.Item;
import checkout.types.Apple;
import checkout.deals.XForYDeal;

public class TwoForOneAppleProcessor implements Function<List<Item>, List<Item>> {
   public List<Item> apply(List<Item> items) {
      List<Item> result = new LinkedList<Item>();
      Apple firstApple = null;
      for (Item item : items) {
         if (item instanceof Apple) {
            if (firstApple == null) {
               firstApple = (Apple) item;
            } else {
               result.add(new XForYDeal(1, firstApple, (Apple) item));
               firstApple = null;
            }
         } else {
            result.add(item);
         }
      }
      if (firstApple != null) {
         result.add(firstApple);
      }
      return result;
   }
}
