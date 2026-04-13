public class ItemToPurchase {
   private String itemName;
   private int itemPrice;
   private int itemQuantity;
   private String itemDescription;

   public ItemToPurchase() {
      itemName = "none";
      itemPrice = 0;
      itemQuantity = 0;
      itemDescription = "none";
   }

   public ItemToPurchase(String name, String description, int price, int quantity) {
      itemName = name;
      itemDescription = description;
      itemPrice = price;
      itemQuantity = quantity;
   }


   public void setName(String name) {
      this.itemName = name;
   }
   public String getName() {
      return itemName;
   }
   public void setPrice(int itemPrice) {
      this.itemPrice = itemPrice;
   }
   public int getPrice() {
      return itemPrice;
   }
   public void setQuantity(int itemQuantity) {
      this.itemQuantity = itemQuantity;
   }
   public int getQuantity() {
      return itemQuantity;
   }
   public void setDescription(String itemDescription) {
      this.itemDescription = itemDescription;
   }
   public String getDescription() {
      return itemDescription;
   }

   public void printItemCost() {
      System.out.printf("\n%s %d @ $%d = $%d", itemName, itemQuantity, itemPrice, itemPrice * itemQuantity);
   }
   public void printItemDescription() {
      System.out.println(itemName + ": " + itemDescription);
   }
}  
