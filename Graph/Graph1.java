import java.util.Scanner;

class BookShelf {
    int top;
    String[] bs;
    int size;

    BookShelf(int size) {
        this.size = size;
        this.bs = new String[size];
        this.top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(String book) {
        // full case
        if (top == size - 1) {
            return;
        }
        bs[++top] = book;

    }

    String pop() {
        if (isEmpty()) {
            return "None";
        }
        String remBook = bs[top];
        top--;
        size--;
        return remBook;
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("None");
        } else {
            System.out.print(bs[top] + " ");
        }
    }
}

public class Graph1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BookShelf myBS = new BookShelf(n);
        for (int i = 1; i <= n; i++) {
            String book = sc.next();
            myBS.push(book);
        }
        if (myBS.isEmpty()) {
            System.out.print("True ");
        } else {
            System.out.print("False ");
        }

        int x = sc.nextInt();
        while (!myBS.isEmpty() && x > 0) {
            myBS.pop();
            x--;
        }
        myBS.peek();
        System.out.print(myBS.size + " ");
    }
}
