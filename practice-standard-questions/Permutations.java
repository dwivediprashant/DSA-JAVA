
import java.util.Scanner;
public class Permutations {
    public static void getPermutations(StringBuilder str, String ans,int currIdx){
        //base case
        if(currIdx==str.length()){
            if(ans.length()==0){
                System.out.println("Null set");
            }else{
                System.out.println(ans);
            }
            return;
        }
        // recursion task
        getPermutations(str, ans+str.charAt(currIdx),currIdx+1);//-- yes include
        //during backtracking
        getPermutations(str, ans, currIdx+1);//--not included
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string : ");
        StringBuilder str=new StringBuilder(sc.next());
        String ans="";
        getPermutations(str,ans,0);
        sc.close();
    }
}
