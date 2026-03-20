package Queue.revise;

public class ImplementationQ {
    public static class Queue {
        int maxSize;
        int front;
        int rear;
        int[] q;

        Queue(int size) {
            maxSize = size;
            front = rear = -1;
            q = new int[maxSize];
        }
        // enqueue method

        void enqueue(int data) {
            // overflow condition
            if (rear == maxSize - 1) {
                System.out.println("----------Q is full------------");
                return;
            }
            // empty case:
            if (front == -1) {
                front = 0;
            }
            rear = rear + 1;
            q[rear] = data;

        }

        // poll is smae as dequeue but in poll we ve to return the deleted ele but i did
        // in dequeue so poll is same as deuque in this implementation
        int dequeue() {
            int delVal;
            // empty case
            if (rear == -1) {
                System.out.println("--------------Empty queue--------------------------");
                return Integer.MIN_VALUE;
            }
            if (front == rear) {
                delVal = q[front];
                front = rear = -1;
            } else {
                delVal = q[front];
                front = front + 1;
            }

            return delVal;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        // q.enqueue(60);//full condiiton
        System.out.println("dequqed ele : " + q.dequeue());
        System.out.println("dequqed ele : " + q.dequeue());
        System.out.println("dequqed ele : " + q.dequeue());
        System.out.println("dequqed ele : " + q.dequeue());
        System.out.println("dequqed ele : " + q.dequeue());
        System.out.println("dequqed ele : " + q.dequeue());
    }
}
