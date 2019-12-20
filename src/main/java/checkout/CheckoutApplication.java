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
    *
    * Note: I know that it would be simpler to loop with a switch statement that adds
    * to a sum, but while not being aware of the second step, I know that there is a
    * second step (akin to knowing there are future improvements to a system on the
    * horizon); given that, I opted to add a couple of files worth of complexity to
    * make the code more extensible and maintainable (at the risk of violating the
    * YAGNI principle.
    *
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
