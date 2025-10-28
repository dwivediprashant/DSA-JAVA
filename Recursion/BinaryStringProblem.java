import java.util.*;
public class BinaryStringProblem {
    
    public static void printAllPossibleBinStr(int n,StringBuilder sb){
        if(n==0){
            System.out.println(sb);
            return;
        }
        sb.append("0");
        printAllPossibleBinStr(n-1,sb);
        sb.setLength(sb.length()-1);
        sb.append("1");
        printAllPossibleBinStr(n-1,sb);
        sb.setLength(sb.length()-1);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=3;
        StringBuilder sb = new StringBuilder("");
        printAllPossibleBinStr(n,sb);
    }
    
}