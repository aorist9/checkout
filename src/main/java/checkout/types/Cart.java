package checkout.types;

import java.util.List;
import java.util.LinkedList;
import java.math.BigDecimal;

public class Cart {
   private List<Item> items = new LinkedList<>();

   public List<Item> getItems() {
      return this.items;
   }

   public void addItem(Item item) {
      this.items.add(item);
   }

   public BigDecimal getTotal() {
      BigDecimal sum = BigDecimal.ZERO;
      for (Item item : this.items) {
         sum = sum.add(item.getPrice());
      }
      return sum;
   }
}
