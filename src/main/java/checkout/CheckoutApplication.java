package checkout;

import checkout.types.Cart;
import checkout.types.Item;

public class CheckoutApplication {
   public static void main(String[] args) {
      Cart cart = new Cart();
      for (String item : args) {
         cart.addItem(Item.getItem(item));
      }
      System.out.println("Your total is \u00A3" + cart.getTotal());
   }
}
