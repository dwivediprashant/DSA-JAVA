import java.util.*;
public class Transpose {
    public static void transpose(int[][] matrix){
        int [][] trans=new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                trans[j][i]=matrix[i][j];
            }
        }
        //printing transpose
        for(int i=0;i<trans.length;i++){
            for(int j=0;j<trans[0].length;j++){
                System.out.print(trans[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void optimizeTranspose(int[][] matrix){
        int temp;
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                //swap
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
            
        }
        //printing transpose
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[][]matrix={{1,2,3},{4,3,7},{7,4,-5}};
        // transpose(matrix);//O(n^2) space and O(n^2) time
        optimizeTranspose(matrix);//only for square matrix O(1) space O(n^2) time
        sc.close();
    }
    
}