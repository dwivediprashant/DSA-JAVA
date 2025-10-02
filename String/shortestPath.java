import java.util.*;
public class shortestPath {
    public static double getDisplacement(String path){
        int abscissa=0;
        int ordinate=0;
        double displace=0;
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='N'){
                ordinate++;
            }else if(path.charAt(i)=='W'){
                abscissa--;
            }else if(path.charAt(i)=='S'){
                ordinate--;
            }else if(path.charAt(i)=='E'){
                abscissa++;
            }
        }
        displace= Math.sqrt(abscissa*abscissa+ordinate*ordinate);
        return displace;

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String path="WNEENESENNN";
        System.out.println(getDisplacement(path));
    }
    
}