public class MethodOverloading {
    public static void main(String[] args) {
        Calculator c1=new Calculator();
        System.out.println( c1.sum(2,2));
        System.out.println( c1.sum(9,2,4));
        System.out.println( c1.sum(2,2.99f));
    }
}
class Calculator{
    int sum(int a, int b){
        return a+b;
    }
    float sum(int a,float b){
        return a+b;
    }
    int sum(int a,int b,int c){
        return a+b+c;
    }
}