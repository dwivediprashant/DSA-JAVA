import java.util.*;

public class SumFun {
    public static int calcSum(int num1, int num2) {// formal parameters
        return num1 + num2;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two values :");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int sum = calcSum(num1, num2);// arguments or actual parameters
        System.out.print("Sum : " + sum);
        sc.close();
    }

}