import java.util.*;
public class SearchInSortMatrix {
    public static boolean staircaseSearch(int[][] matrix,int key){
        int row=matrix.length-1;
        int col=0;
        while(row>=0 && col<=matrix[0].length-1){
            if(matrix[row][col]==key){
                System.out.println(key+" found at ("+ row+" , "+ col + ")");
                return true;
            }
            if(key<=matrix[row][col]){
                row--;
            }else{
                col++;
            }
        }
        System.out.println(key + "  not found !");
        return false;
    }
    public static boolean binarySearch(int[][] matrix , int key){
        int left,right,mid;
        for(int row=0;row<matrix.length;row++){
            left=0;
            right=matrix[0].length-1;
            while(left<=right){
                mid=left + (right-left)/2;
                if(matrix[row][mid]==key){
                    System.out.println(key+" found at ("+ row + " , "+ mid+")");
                    return true;
                }
                if(matrix[row][mid]>key){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        System.out.println(key+" not found!");
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        int key=6;
        staircaseSearch(matrix,key);//O(row+col)
        binarySearch(matrix,9);//O(nlogn)
    }
    
}