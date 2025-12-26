package backtracking;
import java.util.*;
public class Subsets {
    public static void totalSubsets(String str,int stIdx, String subset){
        if(stIdx == str.length()){
            if(subset.isEmpty()){
                System.out.println("{null set}");
            }else{
                System.out.println("{" + subset+"}");
            }
           
            return;
        }
        totalSubsets(str, stIdx+1,subset+str.charAt(stIdx));
        totalSubsets(str, stIdx+1,subset);

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str= sc.next();
        String subset="";
        totalSubsets(str, 0, subset);
        sc.close();
    }
}
