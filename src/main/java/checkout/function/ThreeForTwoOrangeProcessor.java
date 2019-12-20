package checkout.function;

import java.util.List;
import java.util.LinkedList;
import java.util.function.Function;

import checkout.types.Item;
import checkout.types.Orange;
import checkout.deals.XForYDeal;

public class ThreeForTwoOrangeProcessor implements Function<List<Item>, List<Item>> {
   public List<Item> apply(List<Item> items) {
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
   }
}
