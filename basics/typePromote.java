import java.util.*;
public class typePromote {//type promotion occur in only EXPRESSIONS a+b, a-b*c like these
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //1--> short, byte, char converted to int 2---> if float, double or long present in EXPRESIION then larger will rule
        // byte bt=23;
        // bt=bt+2;//bt+2 will become int type and lossy conversion occur which not allowed by java
        // System.out.print(bt);
        //2nd rule
        long lg=23;
        double db=56;
        float f=34f;
        // int result=lg+db+f;//error
        // float result=lg+db+f;
        double result=lg+db+f;
        System.out.print(result);

    }
    
}