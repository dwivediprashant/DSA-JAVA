package Queue.revise;

public class Cq {
    int front;
    int rear;
    int[] q;
    int maxSize;

    Cq(int size) {
        maxSize = size;
        q = new int[maxSize];
        front = rear - 1;
    }

    // wnqueu
    void enqueue(int data) {
        // fullcase
        if ((front == 0 && rear == maxSize - 1) || (front == rear + 1)) {
            System.out.println("--------Full q-------------");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % maxSize;
        q[rear] = data;
    }

    // dequeue

    int dequeue() {
        int delVal;
        // empty case
        if (rear == -1) {
            System.out.println("Empty q----------------------");
            return Integer.MIN_VALUE;
        }
        delVal = q[front];
        if (front == rear) {
            front = rear - 1;
        } else {
            front = (front + 1) % maxSize;
        }

        return delVal;
    }

    public static void main(String[] args) {

    }
}
