import java.util.*;
public class DiagonalSum {
    public static int diagSum(int[][] mat){
        int diagSum=0;
        // for(int i=0;i<mat.length;i++){
        //     diagSum+=mat[i][i];
        //     //secondary diagonal
        //     if(i!=mat.length-1-i)
        //         diagSum+=mat[i][mat.length-1-i];
        // }
        int row=mat.length-1;
        int col=mat[0].length-1;
        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(i==j){
                    diagSum+=mat[i][j];
                }else if(i+j==row){
                    diagSum+=mat[i][j];
                }
                
            }
        }
        return diagSum;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[][] mat={{1,2,3},
              {4,5,6},
              {7,8,9}};
        System.out.print(diagSum(mat)) ;
        sc.close();
    }
    
}