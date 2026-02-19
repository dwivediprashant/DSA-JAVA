package ArrayList;
import java.util.ArrayList;
public class Max {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            int num=(int)Math.ceil(Math.random()*10);
            list.add(num);
        }
        System.out.println(list);
        //max
        int max=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i) > max){
                max=list.get(i);
            }
        }
        System.out.println(max);
    }
}
