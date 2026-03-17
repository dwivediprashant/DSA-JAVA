import java.util.ArrayList;
import java.util.Collections;

public class FoodStamps {

    public static ArrayList<Integer> getAllTastePoint(int[] v, int[] d, int max) {
        int times = 0;
        ArrayList<Integer> allTastePoints = new ArrayList<>();
        while (times < max) {

            for (int i = 0; i < v.length; i++) {
                int tastePoint = v[i] - d[i] * times;
                allTastePoints.add(tastePoint);

            }

            times++;

        }
        return allTastePoints;
    }

    public static int getMaxFromAllTastePoints(ArrayList<Integer> allTastePoints, int max) {
        Collections.sort(allTastePoints, Collections.reverseOrder());
        int maxTastePoint = 0;
        for (int i = 0; i < max; i++) {
            if (allTastePoints.get(i) > 0) {
                maxTastePoint += allTastePoints.get(i);
            }
        }

        return maxTastePoint;

    }

    public static void main(String[] args) {
        int[] v = { 4, 3 };
        int[] d = { 10, 10 };
        int max = 3;
        ArrayList<Integer> allTastePoints = getAllTastePoint(v, d, max);
        System.out.println(getMaxFromAllTastePoints(allTastePoints, max));
    }
}
