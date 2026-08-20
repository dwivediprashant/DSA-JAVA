import java.util.*;

public class UnorderedPairs {
    public static int countUnorderedPairs(int[] arr, int d, int m) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) % d == 0 && ((Math.abs(arr[i] - arr[j])) % m == 0)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countUnorderedPairs2(int[] arr, int d, int m) {

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++)


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
        }

        System.out.println(countUnorderedPairs(arr, d, m));

    }
}
