import java.util.*;

public class SwitchSt {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("choice 1");
                break;
            case 2:
                System.out.print("choice 2");
                break;
            case 3:
                System.out.print("choice 3");
                break;
            default:
                System.out.print("choice is unknown");
        }
        sc.close();
    }

}