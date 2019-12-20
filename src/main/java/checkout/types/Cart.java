package checkout.types;

import java.util.List;
import java.util.LinkedList;
import java.util.function.Function;
import java.math.BigDecimal;

/**
 * Cart - an object representing a cart of items to be bought
 */
public class Cart {
   private List<Item> items = new LinkedList<>();
   private Function<List<Item>, List<Item>>[] preprocessors;

   /**
    * default constructor
    */
   public Cart() {
      preprocessors = (Function<List<Item>, List<Item>>[]) new Function[0];
   }

   /**
    * constructor with preprocessors
    * @param preprocessors Function lambdas that pre-process the list for
    *                      deals and any other modifications
    */
   public Cart(Function<List<Item>, List<Item>> ...preprocessors) {
      this.preprocessors = preprocessors;
   }

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
      List<Item> processedItems = preprocessList();
      BigDecimal sum = BigDecimal.ZERO;
      for (Item item : processedItems) {
         sum = sum.add(item.getPrice());
      }
      return sum;
   }

   /**
    * preprocessList - runs preprocessing functions against the list of items
    * and returns a modified list
    * @return a list modified by the object's preprocessors
    */
   private List<Item> preprocessList() {
      List<Item> result = this.items;
      for (Function<List<Item>, List<Item>> processor : this.preprocessors) {
         result = processor.apply(result);
      }
      return result;
   }
}
