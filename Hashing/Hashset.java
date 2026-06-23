import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Hashset {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Hello");
        set.add("hello");
        set.add("hello");
        set.add(null);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.remove(null));
        System.out.println(set);
        System.out.println(set.contains("hello"));
        System.out.println(set.contains("hello2"));
        System.out.println(set.isEmpty());

        Iterator i = set.iterator();
        System.out.println("============Using iterator===========");
        while (i.hasNext()) {
            System.out.print(i.next() + " ,");
        }
        System.out.println("\n===========Using for each loop==================");

        for (String ele : set) {
            System.out.print(ele + " ,");
        }

        System.out.println();
        // no insertion order and sorting order maintained
        System.out.println(set);

        // insertion order maintained
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(4);
        lhs.add(9);
        lhs.add(9);
        lhs.add(3);
        lhs.add(7);
        System.out.println(lhs);

        // sorting maintained - by default ascending
        TreeSet<Integer> ths = new TreeSet<>();
        ths.add(4);
        ths.add(9);
        ths.add(9);
        ths.add(3);
        ths.add(7);
        System.out.println(ths);
    }
}
