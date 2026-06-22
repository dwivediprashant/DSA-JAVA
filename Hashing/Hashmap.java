package Hashing;

import java.util.HashMap;
import java.util.Set;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("tea", 20);
        hm.put("coffee", 30);
        hm.put("pizza", 30);
        hm.remove(30);
        System.out.println(hm.get("tea"));
        System.out.println(hm.containsKey("tea"));// true
        System.out.println(hm.containsKey("milk"));// false
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());

        Set<String> keys = hm.keySet();

        System.out.println(keys);

    }
}
