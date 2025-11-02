import java.util.*;
public class calculator {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("----------CALCULATOR------------\n");
        int q=1;
        while(q!=0){
            System.out.print("Enter first number :");
            int num1=sc.nextInt();
            System.out.print("Enter second number :");
            int num2=sc.nextInt();
            System.out.print("Enter  + , - , * , / , %  to perform operation : ");

            String op =sc.next();
            
            switch(op){
                case "+":
                    System.out.print("Add : "+(num1+num2));
                    break;
                case "-":
                    System.out.print("Subtract : "+ (num1-num2));//use parenthesis in calculation to skip promotion in expression
                    break;
                case "*":
                    System.out.print("Multiply : "+(num1*num2));
                    break;
                case "/":
                    System.out.print("Division : "+(num1/num2));
                    break;
                case "%":
                    System.out.print("Remainder : "+(num1%num2)); 
                    break;
                default:
                    System.out.print("Enter valid opeartion +, -, *, /, % ");       
            }
            System.out.print("\nEnter 0 to quit & any other number to continue: ");
            q=sc.nextInt();
            
        }
          sc.close();  
    }
    
}