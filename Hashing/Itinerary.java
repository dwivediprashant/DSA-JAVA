import java.util.*;

//You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

public class Itinerary {
    public static ArrayList<String> getItinerary(ArrayList<String[]> tickets) {
        // convert tickets to map
        HashMap<String, String> map = new HashMap<>();// from:to
        for (String[] t : tickets) {
            map.put(t[0], t[1]);
        }

        // to know start& end point
        HashMap<String, String> revMap = new HashMap<>();// to:from
        for (String[] t : tickets) {
            revMap.put(t[1], t[0]);
        }
        Set<String> keys = map.keySet();
        String startPoint = "";

        for (String k : keys) {
            if (!revMap.containsKey(k)) {
                startPoint = k;
            }
        }

        Set<String> revKeys = revMap.keySet();
        String endPoint = "";
        for (String k : revKeys) {
            if (!map.containsKey(k)) {
                endPoint = k;
            }
        }
        // now trace path from determined start to end point
        ArrayList<String> path = new ArrayList<>();

        while (!startPoint.equals(endPoint)) {
            path.add(startPoint);
            startPoint = map.get(startPoint);
        }

        path.add(endPoint);

        return path;

    }

    public static void main(String[] args) {
        ArrayList<String[]> tickets = new ArrayList<>(Arrays.asList(
                new String[] { "Chennai", "Bengaluru" },
                new String[] { "Mumbai", "Delhi" },
                new String[] { "Goa", "Chennai" },
                new String[] { "Delhi", "Goa" }));

        ArrayList<String> path = getItinerary(tickets);

        System.out.println(path);

    }
}
