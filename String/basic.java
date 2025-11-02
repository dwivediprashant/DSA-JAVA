import java.util.*;
public class basic {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // declaration
        String str1="prashant";
        String str2=new String("prashant");
        System.out.println(str1==str2);//false 
        //input
        // String name=sc.nextLine();
        // System.out.print(name);
        // String str3="34";
        // int num=20;
        // System.out.println(str3.charAt(0));
        //concatenation
        String firstname="prashant";
        String lastname="dwivedi";
        String fullName=firstname+" "+lastname;
        System.out.print(fullName);
        System.out.println(fullName.length());//length method
        System.out.println(fullName.charAt(12));//charAt method
        sc.close();
    }
    
}