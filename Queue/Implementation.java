package Queue;

public class Implementation {
    public static class Queue {
        private int front;
        private int rear;
        private int maxSize;
        private int[] q;

        // intialize queue
        Queue(int size) {
            maxSize = size;
            q = new int[maxSize];
            front = rear = -1;
        }

        // methods
        // isEmpty()

        boolean isEmpty() {
            return rear == -1;
        }

        // enque : Insertion in queue => occur from rear
        void enque(int data) {
            // full queue
            if (rear == maxSize - 1) {
                System.out.println("---------------overflow condition--------------------");
                return;
            }
            if (isEmpty()) {
                ++front;
            }

            q[++rear] = data;
        }

        // dequeue :occur from front
        int dequeue() {
            if (isEmpty()) {
                System.out.println("----------------------Underflow Empty queue condition------------------------");
                return Integer.MIN_VALUE;
            }
            int val = q[front];
            // shift elements
            for (int i = 0; i < rear; i++) {
                q[i] = q[i + 1];
            }
            rear--;

            return val;
        }

        // peek : get frontier ele
        int peek() {
            int val = q[front];
            return val;
        }
        // print queue

        void print() {
            for (int i = front; i <= rear; i++) {
                System.out.print(q[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        // Implementation i = new Implementation();
        // Queue q = i.new Queue(5);
        Queue q = new Queue(5);
        q.enque(10);
        System.out.println("FRONT : " + q.peek());// 10
        q.enque(20);
        System.out.println("FRONT : " + q.peek());// 10
        q.enque(30);
        System.out.println("FRONT : " + q.peek());// 10
        q.enque(40);
        q.enque(50);
        // q.enque(60);// overflow hit
        System.out.println("Dequed element : " + q.dequeue());
        System.out.println("Dequed element : " + q.dequeue());
        System.out.println("Dequed element : " + q.dequeue());
        System.out.println("Dequed element : " + q.dequeue());
        System.out.println("Dequed element : " + q.dequeue());
        System.out.println("Dequed element : " + q.dequeue());// underflow hit
        // q.print();
    }
}
