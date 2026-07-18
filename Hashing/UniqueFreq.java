package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueFreq {
    public static boolean uniqueOccurrences1(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n;) {
            int freq = 0;
            int j = i;
            while (j < n && arr[i] == arr[j]) {
                freq++;
                j++;
            }
            if (set.contains(freq)) {
                return false;
            }
            set.add(freq);
            i = j;
        }
        return true;
    }

    public static boolean uniqueOccurrences2(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for (int k : freqMap.keySet()) {
            if (set.contains(freqMap.get(k))) {
                return false;
            }
            set.add(freqMap.get(k));
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 1, 3 };
        // 1st approach => time : O(nlogn) space :O(n)
        System.out.println(uniqueOccurrences1(arr));
        // 2nd approach => time :O(n) space : O(n)
        System.out.println(uniqueOccurrences2(arr));
    }
}
