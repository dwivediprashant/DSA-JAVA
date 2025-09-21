import java.util.*;
public class basicOp  {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int marks[]=new int[5];//array declaration
        //input
        System.out.print("Enter marks :");
        for(int i=0;i<marks.length;i++){
            marks[i]=sc.nextInt();
        }
        //output
        System.out.print("You marks are : ");
        for(int i=0;i<marks.length;i++){
            System.out.println(marks[i]);;
        }
    }
    
}