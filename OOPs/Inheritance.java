public class Inheritance {
    public static void main(String[] args) {
        Car c1=new Car();
        c1.start();
        c1.stop();
        c1.speed=40;
        c1.color="green";
        System.out.println(c1.speed+" kmph");
        System.out.println(c1.color);
        Maruti m1=new Maruti();
        m1.start();
        m1.color="red";
        System.out.println(m1.color);
        Aeroplane a1= new Aeroplane();
        a1.flyTime="9 O'clock morning";
        a1.start();
        a1.takeoff();
        System.out.println(a1.flyTime);
    }
}
class Vehicle{
    int speed;
    int wheels;
    void start(){
        System.out.println("Start...");
    }
    void stop(){
        System.out.println("Stop !");
    }
}
class Car extends Vehicle{
    String color;
    String brand;
}

class Maruti extends Car{
    int price;
    int topSpeed;
    String fuelType;
}
class Aeroplane extends Vehicle{
    String flyTime;
    int wings;
    void takeoff(){
        System.out.println("Takeoff");
    }
}
