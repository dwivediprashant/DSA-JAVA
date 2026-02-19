package ArrayList;
import java.util.ArrayList;
public class Reverse {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        //inp-  5 vals
        for(int i=0;i<5;i++){
            list.add(i*i);
        }
        System.out.println(list);
        //reverse : by reversed() method and loop
        //reverse method
        System.out.println(list.reversed());
        //reverse loop
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+"  ");
        }
    }
}
