public class Constructor {
    public static void main(String[] args) {
        Book b1=new Book();
        Book b2=new Book("Basu");
        Book b3=new Book(231);
    }
}

class Book{
    String title;
    int price;
    //non-parametrized constructor
    Book(){
        System.out.println(this+ " Constructor called");
    }
    //parametrized
    Book(String title){
        this.title=title;
        System.out.println(this+ " Book title : "+title);
    }
    Book(int price){
        this.price=price;
        System.out.println(this + " price is "+price);
    }
}