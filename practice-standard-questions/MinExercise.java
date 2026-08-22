import java.util.*;

public class MinExercise {
    public static int minExerciseToTired(int[] energy, int availableEnergy) {
        Arrays.sort(energy);
        int countExe = 0;
        for (int i = energy.length - 1; i >= 0; i--) {
            int countTimes = 0;
            while (availableEnergy >= energy[i] && countTimes < 2) {
                availableEnergy -= energy[i];
                countExe++;
                countTimes++;
            }
        }
        if (availableEnergy > 0) {
            return -1;
        }
        return countExe;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int availableEnergy = sc.nextInt();
        int n = sc.nextInt();
        int[] energy = new int[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            energy[i] = x;
        }

        System.out.println(minExerciseToTired(energy, availableEnergy));
    }
}
