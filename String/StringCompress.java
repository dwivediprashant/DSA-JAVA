import java.util.*;
public class StringCompress {
    public static void compress(String str){
        int n=str.length();
        StringBuilder compress=new StringBuilder("");
        for(int i=0;i<n;i++){
            int count=1;
            while(i<n-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            compress.append(str.charAt(i));
            if(count>1){
                compress.append(count);
            }
        }
        System.out.print(compress);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str="aabbfaaaccc";//a2b2fa3c3
        compress(str);
    }
    
}