import java.util.*;
public class largestInArray {
    public static void largestAndSmallest(int numbers[]){
        if(numbers.length==0){
            return;
        }
            int max=numbers[0];
            int min=numbers[0];
            for(int i=1;i<numbers.length;i++){
                if(numbers[i]>max){
                    max=numbers[i];
                }
                if(numbers[i]<min){
                    min=numbers[i];
                }
            }
            System.out.println("Largets : "+ max);
            System.out.println("samllest : "+ min);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int numbers[]={56,98,-7,-78,56};
        largestAndSmallest(numbers);
    }
    
}