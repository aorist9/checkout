package checkout.types;

import java.util.List;
import java.util.LinkedList;
import java.math.BigDecimal;

/**
 * Cart - an object representing a cart of items to be bought
 */
public class Cart {
   private List<Item> items = new LinkedList<>();

   /**
    * getItems - gets the items in the cart
    * @return a list of items in the cart
    */
   public List<Item> getItems() {
      return this.items;
   }

   /**
    * addItem - adds an item to the cart
    * @param item the item added to the cart
    */
   public void addItem(Item item) {
      this.items.add(item);
   }

   /**
    * getTotal - retrieves the total price of the cart
    * @return a BigDecimal value with the total price of the cart
    */
   public BigDecimal getTotal() {
      BigDecimal sum = BigDecimal.ZERO;
      for (Item item : this.items) {
         sum = sum.add(item.getPrice());
      }
      return sum;
   }
}
