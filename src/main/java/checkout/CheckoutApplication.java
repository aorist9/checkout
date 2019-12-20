package checkout;

import java.util.List;
import java.util.LinkedList;

import checkout.types.Cart;
import checkout.types.Item;
import checkout.types.Apple;
import checkout.types.Orange;
import checkout.deals.XForYDeal;
import checkout.function.TwoForOneAppleProcessor;
import checkout.function.ThreeForTwoOrangeProcessor;

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
      Cart cart = new Cart(new TwoForOneAppleProcessor(), new ThreeForTwoOrangeProcessor());

      for (String item : args) {
         cart.addItem(Item.getItem(item));
      }
      System.out.println("Your total is \u00A3" + cart.getTotal());
   }
}
