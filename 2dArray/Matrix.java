import java.util.*;
public class Matrix {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[][] matrix=new int[3][3];
        int rows=matrix.length;
        int col=matrix[0].length;
        System.out.print("Enter values : ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("Values are : ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
    
}