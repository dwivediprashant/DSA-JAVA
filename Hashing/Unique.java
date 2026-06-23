import java.util.*;

public class Unique {
    public static ArrayList<Integer> getUnique1(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> unique = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int toCheck = nums[i];
            boolean isPresent = false;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (nums[j] == toCheck) {
                    isPresent = true;
                }
            }
            if (!isPresent) {
                unique.add(toCheck);
            }
        }
        return unique;
    }

    public static ArrayList<Integer> getUnique2(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> unique = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();// key(number) : isDuplicate(bool)

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], false);
            } else if (!map.get(nums[i])) {// !map.get(nums[i]) [optional]=> this prevent repetitive update of true for
                                           // same key
                map.put(nums[i], true);
            }
        }

        Set<Integer> keys = map.keySet();

        for (int k : keys) {
            if (map.get(k) == false) {// it means its not duplicate
                unique.add(k);
            }
        }

        return unique;
    }

    public static ArrayList<Integer> getUnique3(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> unique = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    unique.add(nums[i]);
                }
            } else if (i == n - 1) {
                if (nums[i - 1] != nums[i]) {
                    unique.add(nums[i]);
                }
            } else {
                if (nums[i] != nums[i + 1] && nums[i - 1] != nums[i]) {
                    unique.add(nums[i]);
                }
            }
        }

        return unique;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 3, 4, 7, 1, 1, 5, 12, 12 };
        // output : return list of distinct element => [4,7,5]

        // 1st way - Brute force => time:O(n square) , space:O(n) for storing result
        System.out.println(getUnique1(nums));
        // 2nd way - using hashmap => time : O(n) , space : O(n+m+s) ~ O(n) , n is list
        // size + m is map size + s is key set size

        System.out.println(getUnique2(nums));

        // 3rd way - using sorting => time : O(nlogn+n) ~ O(nlogn) ie sorting(nlogn) ,
        // space :O(n) n list size
        System.out.println(getUnique3(nums));

    }

}
