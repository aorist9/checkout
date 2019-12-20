package checkout.deals;

import java.math.BigDecimal;

import checkout.types.Item;

/**
 * XForYDeal - a wrapper class that wraps multiple Items in order to apply
 * a deal to in which only a certain number of the items are paid for
 * @param T the type of the item (this makes the assumption that all the
 *          items are of the same class or a subclass)
 */
public class XForYDeal<T extends Item> extends Item {
   private final int numberPaidFor;
   private final T[] items;

   /**
    * allArgsConstructor - populates the necessary data
    * @param numberPaidFor the number of items that will be paid for
    * @param items the items involved in the deal. If it matters which items
    *              are paid for, the ones paid for should come first.
    */
   public XForYDeal(int numberPaidFor, T ...items) {
      this.numberPaidFor = numberPaidFor;
      this.items = items;
   }

   @Override
   public BigDecimal getPrice() {
      BigDecimal sum = BigDecimal.ZERO;
      for (int i = 0; i < numberPaidFor; i++) {
         sum = sum.add(items[i].getPrice());
      }
      return sum;
   }
}
