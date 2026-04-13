import java.util.ArrayList;

public class ShoppingCart {
   private String customerName;
   private String currentDate;
   private ArrayList<ItemToPurchase> cartItems;

   public ShoppingCart() {
      customerName = "none";
      currentDate = "January 1, 2016";
      cartItems = new ArrayList<ItemToPurchase>();
   }

   public ShoppingCart(String customerName, String currentDate) {
      this.customerName = customerName;
      this.currentDate = currentDate;
      cartItems = new ArrayList<ItemToPurchase>();
   }

   public String getCustomerName() {
      return customerName;
   }
   public String getDate() {
      return currentDate;
   }

   public void addItem(ItemToPurchase item) {
      cartItems.add(item);
   }
   public void removeItem(String itemName) {
      boolean found = false;
      for (ItemToPurchase item : cartItems) {
         if (item.getName().equals(itemName)) {
            cartItems.remove(item);
            found = true;
            break;
            }
         }
         if (!found) {
            System.out.print("\nItem not found in cart. Nothing removed.");
         }
   }
   public void modifyItem(ItemToPurchase selectedItem) {
      boolean found = false;
      for (ItemToPurchase item : cartItems) {
         if (item.getName().equals(selectedItem.getName())) {
            if (!selectedItem.getDescription().equals("none"))
               item.setDescription(selectedItem.getDescription());
            if (selectedItem.getPrice() != 0)
               item.setPrice(selectedItem.getPrice());
            if (selectedItem.getQuantity() != 0)
               item.setQuantity(selectedItem.getQuantity());
            found = true;
            break;
         }
   }
      if (!found) {
         System.out.println("Item not found in cart. Nothing modified.");
      }
   }
   public int getNumItemsInCart() {
      int total = 0;
      for (ItemToPurchase item : cartItems) {
         total += item.getQuantity();
      }
      return total;
   }
   public double getCostOfCart() {
      double totalCost = 0;
      for (ItemToPurchase item : cartItems) {
         totalCost += item.getPrice() * item.getQuantity();
      }
      return totalCost;
   }
   public void printTotal() {
      System.out.println("%s's Shopping Cart - %s", customerName, currentDate);
      System.out.println("Number of Items: " + getNumItemsInCart());
      System.out.println();
      if (cartItems.isEmpty()) {
         System.out.println("SHOPPING CART IS EMPTY");
      } else {
         for (ItemToPurchase item : cartItems)
            item.printItemCost();
      }
      System.out.println("\nTotal: $.2f", getCostOfCart());
   }
   public void printDescriptions() {
      for (ItemToPurchase item : cartItems) {
         item.printItemDescription();
      }
   }
}

