import java.util.*;
public class operators {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //unary
        int a=10;
        System.out.println(a++);//first use then inceremnt
        System.out.println(a);
        int b=5;
        System.out.println(b--);//first use then decrement
        System.out.println(b);
        //pre inc dec-----
        int c=9;
        System.out.println(++c);//first use then inceremnt
        System.out.println(c);
        int d=34;
        System.out.println(--d);//first use then inceremnt
        System.out.println(d);
    }
    
}