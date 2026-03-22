import java.util.*;

public class FactFun {
    public static int fact(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        int fact = 1;

        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        System.out.print("factorial  = " + fact(num));
        sc.close();
    }

}