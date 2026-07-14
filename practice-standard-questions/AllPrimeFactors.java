import java.util.Scanner;

public class AllPrimeFactors {
    public static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrimeFactors(int n) {
        int m = n;
        for (int i = 2; i < m;) {
            if (isPrime(i)) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                    n /= i;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
    }

    public static void printPrimeFactors2(int n) {
        int m = n;
        for (int i = 2; i * i <= m; i++) {

            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }

        }
        if (n > 1) {
            System.out.print(n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n = ");
        int n = sc.nextInt();
        printPrimeFactors(n);
        System.out.println();
        printPrimeFactors2(n);
    }
}
