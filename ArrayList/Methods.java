package ArrayList;
import java.util.ArrayList;
public class Methods {
    public static void main(String[] args) {
        // declaration
        ArrayList<Integer> list= new ArrayList<>();
        // methods
        System.out.println(list.isEmpty());
        // add() : return boolean , append at end(n-1th idx) of the list + O(1)
        list.add(20);
        list.add(40);
        list.add(10);
        // addFirst() :  append at first(0th idx) + O(n) due to shifting of ele to resize list
        list.addFirst(99);
        // get() : return val at given idx + O(1)
        int ele=list.get(3);
        System.out.println(ele);
        System.out.println(list);

        // remove(): O(n)
        int remEle=list.remove(2);
        System.out.println(remEle);

        // set(): set val at particular idx by overwriting old val + O(1)
        list.set(0, 23);
        System.out.println(list);

        // size() : length of list
        System.out.println(list.size());
    }
}
