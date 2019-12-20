package checkout;

import java.util.List;
import java.util.LinkedList;

import checkout.types.Cart;
import checkout.types.Item;
import checkout.types.Apple;
import checkout.types.Orange;
import checkout.deals.XForYDeal;

/**
 * CheckoutApplication - the command line interface class for the Checkout application
 */
public class CheckoutApplication {
   /**
    * main - takes the items to be purchased as command line arguments and prints
    * the price of the cart after applying a two for one deal on apples and a three
    * for two deal on Oranges
    *
    * @param args the array of command line arguments, which will be mapped to items
    */
   public static void main(String[] args) {
      Cart cart = new Cart(
         items -> {
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
         },
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
         });

      for (String item : args) {
         cart.addItem(Item.getItem(item));
      }
      System.out.println("Your total is \u00A3" + cart.getTotal());
   }
}
