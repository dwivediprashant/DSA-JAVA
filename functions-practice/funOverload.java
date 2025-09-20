import java.util.*;
public class funOverload {
    public static float sum(float a,int b){
        System.out.println("float int");
        return a+b;
    }
    public static int sum(int a,int b){
        System.out.println("int int");
        return a+b;
    }
    public static int sum(int a,int b,int c){
        System.out.println("int int int");
        return a+b+c;
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println(sum(5.5f,6)); 
        System.out.println(sum(4,6)); 
        System.out.print(sum(5,6,6)); 
    }
    
}