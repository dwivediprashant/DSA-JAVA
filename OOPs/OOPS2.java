public class OOPS2 {
    public static void main(String[] args) {
        BankAccount b1=new BankAccount();
        b1.username="Prashant";
        b1.setPassword("1234");
    }
}
class BankAccount{
    //access modifiers
    public String username;
    private String password;

    void setPassword(String password){
        this.password=password;
    }
}
