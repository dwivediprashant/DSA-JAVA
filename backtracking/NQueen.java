package backtracking;
import java.util.Scanner;
public class NQueen {

    public static boolean isAboveAvailable(int currRow,int currCol, boolean[][] posMat){
        //base case
        if(currRow==0){
            return true;
        }
        //recursion
        if(posMat[currRow-1][currCol]==true){//it means queen is present above so return false that means place is not avaliable
            return false;
        }
        return isAboveAvailable(currRow-1, currCol, posMat);
    }
    public static boolean isDiagonalAvailable(int currRow,int currCol,boolean[][] posMat){
        //right diagonal above
        int tempRow=currRow;
        int tempCol=currCol;
        while(tempRow>=0 && tempCol<=posMat.length-1){
            if(posMat[tempRow--][tempCol++]){
                return false;
            }
        }
        // left diagonal above
        tempRow=currRow;
        tempCol=currCol;
        while(tempRow>=0 && tempCol>=0){
            if(posMat[tempRow--][tempCol--]){
                return false;
            }
        }
        return true;
    }
    public static boolean[][] placeQueen(int currRow,int currCol,boolean[][] posMat,int n){
        // No solution condition
        if(currRow==0 && currCol==n){
            System.out.println("No solution exist for given "+n+"x"+n+" chessboard!");
            return posMat;
        }
        //base case : rows exceed
        if(currRow==n){
            return posMat;
        }
        //case : when all columns in curr Row explored but not found right place so rollback  to prev  at valid placerow the algo
        if(currCol>n-1){
            int lastIdx=getLastPlaceInPrevRow(currRow-1,posMat,n);
            posMat[currRow-1][lastIdx]=false;
            return placeQueen(currRow-1,lastIdx+1 ,posMat, n);
        }
        //recursion
        boolean isAboveOk=isAboveAvailable(currRow,currCol,posMat);
        boolean isDiagonalOk=isDiagonalAvailable(currRow,currCol,posMat);

        // case : when right place found
        if(isAboveOk && isDiagonalOk){
            posMat[currRow][currCol]=true;
            return placeQueen(currRow+1,0, posMat, n);
        }
        // explore next column in same row when either isAbove return false or isDiagonal return false
        return placeQueen(currRow, currCol+1, posMat, n);
    }
    public static int getLastPlaceInPrevRow(int row,boolean[][] posMat,int n){
        for(int i=0;i<n;i++){
            if(posMat[row][i]==true){
                return i;
            }
        }
        return -1;// this never happen
    }
    public static void printChessBoard(boolean[][] posMat){
        for(int i=0;i<posMat.length;i++){
            System.out.print("| ");
            for(int j=0;j<posMat[0].length;j++){
                if(posMat[i][j]){
                    System.out.print(" Q ");
                }else{
                    System.out.print(" . ");
                }
            }
            System.out.println(" |");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter N = ");
        int n=sc.nextInt();
        boolean[][] posMat=new boolean[n][n];
        boolean[][] placedPos=placeQueen(0,0,posMat,n);
        //print chessboard after placing queen
        printChessBoard(placedPos);
        sc.close();
    }
}
