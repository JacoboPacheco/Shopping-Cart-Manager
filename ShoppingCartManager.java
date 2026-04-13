import java.util.Scanner;

public class ShoppingCartManager {

   public static void printMenu() {
      System.out.println("MENU");
      System.out.println("a - Add item to cart");
      System.out.println("d - Remove item from cart");
      System.out.println("c - Change item quantity");
      System.out.println("i - Output items' descriptions");
      System.out.println("o - Output shopping cart");
      System.out.println("q - Quit\n");
   }

   public static void executeMenu(char input, ShoppingCart cart, Scanner read) {
      switch (input) {
         case 'a':
            System.out.println("ADD ITEM TO CART");
            System.out.println("Enter the item name:");
            String name = read.nextLine();
            System.out.println("Enter the item description:");
            String description = read.nextLine();
            System.out.println("Enter the item price:");
            int price = read.nextInt();
            System.out.println("Enter the item quantity:");
            int quantity = read.nextInt();
            read.nextLine();
            cart.addItem(new ItemToPurchase(name, description, price, quantity));
            break;
         case 'd':
            System.out.println("REMOVE ITEM FROM CART");
            System.out.println("Enter name of item to remove:");
            String removeName = read.nextLine();
            cart.removeItem(removeName);
            break;
         case 'c':
            System.out.println("CHANGE ITEM QUANTITY");
            System.out.println("Enter the item name:");
            String modName = read.nextLine();
            System.out.println("Enter the new quantity:");
            int modQuantity = read.nextInt();
            read.nextLine();
            ItemToPurchase modItem = new ItemToPurchase();
            modItem.setName(modName);
            modItem.setQuantity(modQuantity);
            cart.modifyItem(modItem);
            break;
         case 'i':
            System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
            cart.printDescriptions();
            break;
         case 'o':
            System.out.println("OUTPUT SHOPPING CART");
            cart.printTotal();
            break;
         case 'q':
            break;
         default:
            System.out.println("Choose an option:");
            break;
      }

   }
   public static void main(String[] args) {
      Scanner read = new Scanner(System.in);

      String customerName = "";
      String currentDate = "";
      char input = ' ';

      System.out.println("\nPlease enter customer's name: ");
      customerName = read.nextLine();
      System.out.println("Please enter today's date: ");
      currentDate = read.nextLine();

      System.out.printf("\nCustomer name: %s\nToday's date: %s\n\n", customerName, currentDate);
      ShoppingCart cart = new ShoppingCart(customerName, currentDate);
      
      
      while (input != 'q') {
         printMenu();
         System.out.println("Choose an option:");
         input = read.next().charAt(0);
         read.nextLine();
         if (input != 'q') {
            executeMenu(input, cart, read);
         }
      }

   }
}
