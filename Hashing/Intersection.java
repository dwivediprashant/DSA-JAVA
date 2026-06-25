import java.util.*;

//Leetcode 359
//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
public class Intersection {
    public static int[] getIntersection1(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res.add(nums1[i]);
                }
            }
        }

        int n = res.size();

        int[] ans = new int[n];
        int i = 0;
        for (int x : res) {
            ans[i++] = x;
        }

        return ans;
    }

    public static int[] getIntersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int toFind = nums1[i];
            int left = 0, right = nums2.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums2[mid] == toFind) {
                    set.add(toFind);
                    break;
                } else if (nums2[mid] < toFind) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        int n = set.size();

        int[] ans = new int[n];
        int i = 0;
        for (int x : set) {
            ans[i++] = x;
        }

        return ans;
    }

    public static int[] getIntersection3(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], false);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) == false) {
                map.put(nums2[i], true);
            }
        }
        // System.out.print(map);
        Set<Integer> keys = map.keySet();

        HashSet<Integer> set = new HashSet<>();

        for (int k : keys) {
            if (map.get(k) == true) {
                set.add(k);
            }
        }

        int n = set.size();

        int[] ans = new int[n];
        int i = 0;
        for (int x : set) {
            ans[i++] = x;
        }

        return ans;
    }

    public static int[] getIntersection4(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ansSet = new HashSet<>();

        for (int x : nums1) {
            set.add(x);
        }

        for (int x : nums2) {
            if (set.contains(x)) {
                ansSet.add(x);
            }
        }

        int n = ansSet.size();

        int[] ans = new int[n];
        int i = 0;
        for (int x : ansSet) {
            ans[i++] = x;
        }

        return ans;
    }

    public static int[] getIntersection5(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ptr1 = 0, ptr2 = 0;

        HashSet<Integer> res = new HashSet<>();

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                res.add(nums1[ptr1]);
                ptr1++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }

        int n = res.size();

        int[] ans = new int[n];
        int i = 0;
        for (int x : res) {
            ans[i++] = x;
        }

        return ans;
    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 4 };
        int[] nums2 = { 2, 2, 4 };
        // 1st way time : O(n square) space : O(n) for storing result
        int[] ans1 = getIntersection1(nums1, nums2);
        printArray(ans1);
        System.out.println();
        // 2nd way time : O(nlogn) space : O(n) for storing result
        int[] ans2 = getIntersection2(nums1, nums2);
        printArray(ans2);

        System.out.println();
        // 3rd way using hashmap+hashset time : O(n) space : O(n) for storing result
        int[] ans3 = getIntersection3(nums1, nums2);
        printArray(ans3);

        System.out.println();
        // 4th way using hashset time : O(n) space : O(n) for storing result
        int[] ans4 = getIntersection4(nums1, nums2);
        printArray(ans4);

        System.out.println();
        // 5th way using 2 pointer + sorting; time : O(n) space : O(n) for storing
        // result
        int[] ans5 = getIntersection4(nums1, nums2);
        printArray(ans5);

    }
}
