import java.util.*;
public class hollowRec {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of rows and columns : ");
        int row=sc.nextInt();
        int col=sc.nextInt();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || i==row-1 || j==0 || j==col-1){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
    
}