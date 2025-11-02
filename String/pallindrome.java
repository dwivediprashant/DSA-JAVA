import java.util.*;
public class pallindrome {
    public static boolean isPallindrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str="1022201";
        System.out.println(isPallindrome(str));
        sc.close();
    }
    
}