import java.util.*;
public class callByVal {
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println("a= "+ a);
        System.out.println("b= "+ b);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=10;
        int b=70;
        System.out.println("a= "+ a);
        System.out.println("b= "+ b);
        swap(a,b);
        System.out.println("a= "+ a);
        System.out.print("b= "+ b);
        sc.close();
    }
    
}