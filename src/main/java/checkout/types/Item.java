package checkout.types;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Supplier;

import checkout.types.Apple;

/**
 * Item - represents an item to be bought, abstract rather than an interface
 * since it represents a thing rather than indicating a behavior
 */
public abstract class Item {
   private static Map<String, Supplier<Item>> itemMap = new HashMap<>();

   static {
      itemMap.put("APPLE", () -> new Apple());
   }

   /**
    * getItem - a factory method to generate an Item from a String
    * @param name the name of the Item
    * @return an Item object corresponding to the name
    * @throws NullPointerException if name is null
    */
   public static Item getItem(String name) {
      String key = Objects.requireNonNull(name).toUpperCase();
      if (itemMap.get(key) == null) {
         System.out.println("Unrecognized item " + name + " requested");
	 return null;
      } else {
         return itemMap.get(key).get();
      }
   }

   /**
    * getPrice - returns the price of the item
    * @return the price of the item in BigDecimal form
    */
   public abstract BigDecimal getPrice();
}
