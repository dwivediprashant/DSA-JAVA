import java.util.*;
public class spiral {
    public static void printSpiral(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            //0 th row --> column changing
            for(int j=i;j<col-i;j++){
                System.out.print(matrix[i][j]+" ");
            }
            //last column --> row changing
            for(int j=i+1;j<row-i;j++){
                System.out.print(matrix[j][col-1-i]+" ");
            }
            //bottom row ie last row --> column changing in reverse order
            for(int j=col-2-i;j>=i;j--){
                System.out.print(matrix[row-1-i][j]+" ");
            }
            //first 0th column --> row changing in reverse order
            for(int j=row-2-i;j>i;j--){
                System.out.print(matrix[j][i]+" ");
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[][] matrix = {
    {1, 2, 3, 4, 5},
    {6, 7, 8, 9, 10},
    {11, 12, 13, 14, 15},
    {16, 17, 18, 19, 20}
};
printSpiral(matrix);
sc.close();
    }
    
}