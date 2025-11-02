import java.util.*;
public class Convert {
    public static String getEnglishOf(int num){
        if(num==0){
            return("zero");
        }
        else if(num==1){
            return("one");
        }else if(num==2){
            return("two");
        }else if(num==3){
            return("three");
        }else if(num==4){
            return("four");
        }else if(num==5){
            return("five");
        }else if(num==6){
            return("six");
        }else if(num==7){
            return("seven");
        }else if(num==8){
            return("eight");
        }else if(num==9){
            return("nine");
        }    
        return "";
    }
    public static void intToEnglish(int num,StringBuilder res){
        if(num==0){
            return;
        }
        int remain =num/10;
        int lastDigit=num%10;
        intToEnglish(remain,res);
        res.append(getEnglishOf(lastDigit)+" ");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=2930;
        StringBuilder res=new StringBuilder("");
        intToEnglish(num,res);
        System.out.print(res.toString());
        sc.close();
    }
    
}