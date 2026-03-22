import java.util.*;

public class Inputs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // String name=sc.next();
        // System.out.print(name);
        // String name=sc.nextLine();
        // System.out.print(name);

        System.out.print("Enter value : ");
        int num = sc.nextInt();
        System.out.print("Squared value : ");
        System.out.print(num * num);
        sc.close();
    }

}