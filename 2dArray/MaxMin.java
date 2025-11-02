import java.util.*;
public class MaxMin {
    public static void maxMin(int[][] matrix){
        int max=matrix[0][0];
        int min=matrix[0][0];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]>max){
                    max=matrix[i][j];
                }
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                }
            }
        }
        System.out.println("Maximum : " + max);
        System.out.println("Minimum : " + min);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[][] matrix={{4,5,3},{5,-9,7},{1,5,4}};
        maxMin(matrix);
        sc.close();
    }
    
}