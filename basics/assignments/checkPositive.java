import java.util.*;

public class CheckPositive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        if (num > 0) {
            System.out.print(num + " is positve");
        } else if (num < 0) {
            System.out.print(num + " is negative");
        } else {
            System.out.print(num + " is neither positve nor negative.");
        }
        sc.close();
    }

}