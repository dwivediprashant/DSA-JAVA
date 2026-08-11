import java.util.*;

class Pair implements Comparable<Pair> {
    int st;
    int end;

    Pair(int st, int end) {
        this.st = st;
        this.end = end;
    }

    @Override
    public int compareTo(Pair p) {
        return this.end - p.end;
    }
}

public class Intervals {
    public static int maxActivities(ArrayList<Pair> activities) {
        Collections.sort(activities);
        int count = 0;
        int lastTime = activities.get(0).end;
        count++;
        for (int i = 1; i < activities.size(); i++) {
            Pair act = activities.get(i);
            if (lastTime <= act.st) {
                count++;
                lastTime = act.end;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Pair> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int st = sc.nextInt();
            int end = sc.nextInt();
            Pair p = new Pair(st, end);
            activities.add(p);
        }

        int max = maxActivities(activities);
        System.out.println(max);
    }
}
