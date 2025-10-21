import java.util.*;
public class RemoveDuplicates {
    public static StringBuilder removeDupli(String str,StringBuilder ans,boolean[] map,int i){
        if(i==str.length()){
            // System.out.print(ans);
            return ans;
        }
        int currIdx= str.charAt(i)-'a';
        if(map[currIdx]==false){
            map[currIdx]=true;
            ans.append(str.charAt(i));
            removeDupli(str,ans,map,i+1);
        }else{
            removeDupli(str,ans,map,i+1);
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str = "appnnacollege";//op: apncoleg
        StringBuilder ans= removeDupli(str,new StringBuilder(""),new boolean[26],0);
        System.out.print("Removed dulpicates string : " + ans);
    }
    
}