import java.util.*;

public class MenuInCanteen {
    public static void displayMenu(String menu[]) {
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + " : " + menu[i]);
        }
    }

    public static void greet() {
        System.out.println("***********WELCOME TO DHABA************");
        System.out.println("What you want today? Choose from below items : -");
    }

    public static String takeChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of item : ");
        String choice = sc.nextLine();
        sc.close();
        return choice;

    }

    public static void serveItem(String menu[], String choice) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equalsIgnoreCase(choice)) {
                System.out.print(choice + " is on the table.");
                return;
            }
        }
        System.out.print(choice + " is not available for now.");
    }

    public static void main(String args[]) {

        String menu[] = { "samosa", "pav", "coffee", "tea", "rasgulla", "biscuit" };
        greet();
        displayMenu(menu);
        String choice = takeChoice();
        serveItem(menu, choice);
    }

}