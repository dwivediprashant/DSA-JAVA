public class MethodOverriding {
    public static void main(String[] args) {
        Car c1=new Car();
        c1.start();
    }
}
class Vehicle{
    void start(){
        System.out.println("Vehicle Starting..");
    }
}
class Car  extends Vehicle{
    void start(){
        System.out.println("car start....");
    }
}