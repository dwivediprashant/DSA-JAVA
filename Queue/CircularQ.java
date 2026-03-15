package Queue;

public class CircularQ {
    public static class Cqueue {
        int[] cq;
        int front;
        int rear;
        int maxSize;

        Cqueue(int size) {
            maxSize = size;
            cq = new int[maxSize];
            front = rear = -1;
        }

        // methods
        boolean isEmpty() {
            return front == -1;
        }

        void enque(int data) {

            // full queue condition
            if ((rear + 1) % maxSize == front) {
                System.out.println("--------------Queue is full by enqueue fxn---------------------------------");
                return;
            }
            if (isEmpty()) {// front=-1
                ++front;// front=0
            }
            rear = (rear + 1) % maxSize;
            cq[rear] = data;
        }

        int dequeue() {
            if (isEmpty()) {
                System.out.println("-------------Empty queue by dequeue---------------");
                return Integer.MIN_VALUE;
            }
            int val = cq[front];
            // when last ele deleted then front > rear
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % maxSize;
            }
            return val;
        }

        // peek : give front element

        int peek() {
            if (isEmpty()) {
                System.out.println("-------------Empty queue by peek----------------");
                return Integer.MIN_VALUE;
            }
            int val = cq[front];
            return val;
        }

        void print() {
            if (isEmpty()) {
                System.out.println("---------------Empty queue by print fxn--------");
                return;
            }
            for (int i = front;;) {
                System.out.print(cq[i] + "   ");
                if (i == rear) {
                    break;
                }
                i = (i + 1) % maxSize;
            }

        }

    }

    public static void main(String[] args) {
        Cqueue cq = new Cqueue(5);
        cq.enque(10);
        cq.enque(20);
        cq.enque(30);
        cq.enque(40);
        cq.enque(50);
        System.out.println("Dequeued ele : " + cq.dequeue());
        cq.enque(99);
        cq.print();
        cq.enque(19);
        cq.print();
        System.out.println("\nDequeued ele : " + cq.dequeue());
        System.out.println("Dequeued ele : " + cq.dequeue());
        System.out.println("Dequeued ele : " + cq.dequeue());
        System.out.println("Dequeued ele : " + cq.dequeue());
        System.out.println("Dequeued ele : " + cq.dequeue());
        System.out.println("Dequeued ele : " + cq.dequeue());
        System.out.println("Dequeued ele : " + cq.dequeue());
        cq.print();
    }
}
