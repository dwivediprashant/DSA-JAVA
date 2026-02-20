public class OOPS {
    public static void main(String[] args) {
        Mobile mob=new Mobile();
        mob.setBrandName("Vivo");
        mob.setPrice(23000.99f);
        mob.getMobileDetails();
        // 2nd mobile
        Mobile mob2=new Mobile();
        mob2.setBrandName("Apple");
        mob2.setPrice(24000.95f);
        mob2.getMobileDetails();
        // But since class Mobile has not defined access modifiers and by default its public
        // so w ecan access props and modify them  directly
        mob2.price=0;
        mob2.getMobileDetails();
    }
}

class Mobile{
    //props
    String brandName;
    float price;
    //fxn
    void setBrandName(String brand){
        brandName=brand;
    }
    void setPrice(float newPrice){
        price=newPrice;
    }
    void getMobileDetails(){
        System.out.println("Brand name = "+brandName);
        System.out.println("Price = "+price);
    }
}
