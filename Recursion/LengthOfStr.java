import java.util.*;
public class LengthOfStr {
    public static int getLength(String str){
        if(str.equals("")){
            return 0;
        }
        return 1+ getLength(str.substring(1));
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str="Prashant kumar dwivedi";
        System.out.print(getLength(str));
    }
    
}