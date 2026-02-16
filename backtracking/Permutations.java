package backtracking;
import java.util.*;

public class Permutations {
    public static int findPermutations(String remain,String ans){
        //base case
        if(remain.length()==0){
            System.out.println(ans);
            return 1;
        }
        //recursion
        int totalPermut=0;
        for(int i=0;i<remain.length();i++){
            totalPermut+=findPermutations(remain.substring(0,i)+remain.substring(i+1), ans+remain.charAt(i));
        }
        return totalPermut;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str=sc.next();
        String ans="";
        String remain=str;
        int countPermut=findPermutations(remain,ans);
        System.out.print("Total permutatiomns are : "+countPermut);
        sc.close();
    }
}

