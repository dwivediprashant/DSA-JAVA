import java.util.Scanner;

public class MinPollution {
    // car capacity=4 , van capacity=100
    public static int minPollution(int N, int X, int Y) {
        int minPoll = Integer.MAX_VALUE;
        int maxVanRound = (int) Math.ceil(1.0 * N / 100);
        // System.out.println(maxVanRound);
        int vanRound = maxVanRound;

        while (vanRound >= 0) {
            int byVan = Math.min(N, vanRound * 100);
            int byCar = N - byVan;
            int carRound = (int) Math.ceil(1.0 * byCar / 4);
            int totalPollution = carRound * X + vanRound * Y;
            minPoll = Math.min(minPoll, totalPollution);
            vanRound--;
        }

        return minPoll;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int minPoll = minPollution(N, X, Y);
            System.out.println(minPoll);
        }
    }
}
