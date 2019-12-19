package checkout;

import checkout.types.Cart;
import checkout.types.Item;

/**
 * CheckoutApplication - the command line interface class for the Checkout application
 */
public class CheckoutApplication {
   /**
    * main - takes the items to be purchased as command line arguments and prints
    * the price of the cart
    * @param args the array of command line arguments, which will be mapped to items
    */
   public static void main(String[] args) {
      Cart cart = new Cart();
      for (String item : args) {
         cart.addItem(Item.getItem(item));
      }
      System.out.println("Your total is \u00A3" + cart.getTotal());
   }
}
