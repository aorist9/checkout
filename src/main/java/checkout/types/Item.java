package checkout.types;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Supplier;

/**
 * Item - represents an item to be bought, abstract rather than an interface
 * since it represents a thing rather than indicating a behavior
 */
public abstract class Item {
   private static Map<String, Supplier<Item>> itemRegistry = new HashMap<>();

   /**
    * registerItem - a static method used to register new subclasses of item with
    * their names as strings, so that those new subclasses can be created from their
    * strings without having to alter the Item class
    * @param name the name of the item
    * @param itemSupplier a Supplier (preferably a lambda) did instantiates a
    *                     new Item (not an item, because that would result in
    *                     all Apples being the same Apple object
    */
   public static void registerItem(String name, Supplier<Item> itemSupplier) {
      itemRegistry.put(name, itemSupplier);
   }

   /**
    * getItem - a factory method to generate an Item from a String
    * @param name the name of the Item
    * @return an Item object corresponding to the name
    */
   public static Item getItem(String name) {
      if (itemRegistry.get(name) == null) {
         System.out.println("Unrecognized item " + name + " requested");
	 return null;
      } else {
         return itemRegistry.get(name).get();
      }
   }

   /**
    * getPrice - returns the price of the item
    * @return the price of the item in BigDecimal form
    */
   public abstract BigDecimal getPrice();
}
