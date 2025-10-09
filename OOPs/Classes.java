public class Classes{
    public static void main(String args[]){
        Laptop l=new Laptop();//created l object of Laptop
        l.setBrandName("HP");
        l.setPrice(54000);
        System.out.println(l.brandName);
        System.out.println(l.price);
        l.price=40000;//since  we not protected properties ie no access modifiers
        System.out.print(l.price);
    }
}

class Laptop{
    //properties+function
    String brandName;
    int price;

    void setBrandName(String name){
        brandName=name;
    }
    void setPrice(int p){
        price=p;
    }
}