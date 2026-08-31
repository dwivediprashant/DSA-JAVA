import java.util.*;

class Pair implements Comparable<Pair> {
    char ch;
    int freq;

    Pair(char _ch, int _freq) {
        this.ch = _ch;
        this.freq = _freq;
    }

    @Override
    public int compareTo(Pair p) {
        return p.freq - this.freq;
    }
}

public class Maventic {
    public static char[] getDecreasingOrderOfCharFreq(String[] arr) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String curr = arr[i];
            for (int j = 0; j < curr.length(); j++) {
                char ch = curr.charAt(j);
                if (freqMap.containsKey(ch)) {
                    freqMap.put(ch, freqMap.get(ch) + 1);
                } else {
                    freqMap.put(ch, 1);
                }
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();// max heap
        for (char ch : freqMap.keySet()) {
            Pair p = new Pair(ch, freqMap.get(ch));
            pq.add(p);
        }

        char[] res = new char[freqMap.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = pq.remove().ch;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            arr[i] = str;
        }
        char[] res = getDecreasingOrderOfCharFreq(arr);
        for (char ch : res) {
            System.out.print(ch + " ");
        }
    }
}
