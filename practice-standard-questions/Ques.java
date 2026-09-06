import java.util.*;

public class Ques {
    static class Pair implements Comparable<Pair> {
        String userid;
        int longestStreak;

        Pair(String _userId, int _longestStreak) {
            this.userid = _userId;
            this.longestStreak = _longestStreak;
        }

        @Override
        public int compareTo(Pair p) {
            return this.userid.compareTo(p.userid);
        }
    }

    public static boolean isConsecutiveDays(String curr, String next) {
        int currDay = Integer.parseInt(curr.substring(curr.length() - 2, curr.length()));
        int nextDay = Integer.parseInt(next.substring(next.length() - 2, next.length()));

        if (currDay + 1 == nextDay) {
            return true;
        }
        return false;
    }

    public static int getStreak(List<String> li) {
        int longestStreak = 1;
        int currStreak = 1;
        for (int i = 0; i < li.size() - 1; i++) {
            if (isConsecutiveDays(li.get(i), li.get(i + 1))) {
                currStreak++;
            } else {
                longestStreak = Math.max(currStreak, longestStreak);
                currStreak = 1;
            }
        }
        return Math.max(longestStreak, currStreak);
    }

    public static void getLongestStreak(HashMap<String, List<String>> map) {
        for (String k : map.keySet()) {
            Collections.sort(map.get(k));
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String k : map.keySet()) {
            int longestStreak = getStreak(map.get(k));
            map2.put(k, longestStreak);
        }
        int maxStreak = -1;
        for (String k : map2.keySet()) {
            int s = map2.get(k);
            if (s > maxStreak) {
                maxStreak = s;
            }
        }
        List<Pair> res = new ArrayList<>();
        for (String k : map2.keySet()) {
            if (map2.get(k) == maxStreak) {
                Pair p = new Pair(k, map2.get(k));
                res.add(p);
            }
        }

        Collections.sort(res);

        for (Pair p : res) {
            System.out.println(p.userid + " " + p.longestStreak);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String userId = sc.next();
            String date = sc.next();
            if (map.containsKey(userId)) {
                map.get(userId).add(date);
            } else {
                HashSet<String> set = new ArrayList<>();
                set.add(date);
                map.put(userId, set);
            }
        }

        getLongestStreak(map);
    }
}
