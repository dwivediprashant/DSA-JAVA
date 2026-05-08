
import java.util.ArrayList;

//MIN HEAP
public static class MinHeap {
    ArrayList<Integer> minHeap;

    MinHeap() {
        minHeap = new ArrayList<>();
    }

    private void heapify(int addedAt) {
        int parentIdx = (addedAt - 1) / 2;
        if (addedAt == 0) {
            return;
        }
        if (minHeap.get(parentIdx) > minHeap.get(addedAt)) {
            int temp = minHeap.get(parentIdx);
            minHeap.set(parentIdx, minHeap.get(addedAt));
            minHeap.set(addedAt, temp);
            heapify(parentIdx);
        }
    }

    public void add(int ele) {
        minHeap.add(ele);
        // element added at last
        int addedAt = minHeap.size() - 1;
        // now fix the min heap property : parent < child
        heapify(addedAt);
    }

    public int peek() {
        return minHeap.get(0);
    }

    private void heapifyAfterDelete(int parentIdx) {
        int leftChildIdx = 2 * parentIdx + 1;
        int rightChildIdx = 2 * parentIdx + 2;

        if (leftChildIdx >= minHeap.size()) {
            return;
        }

        int minChildIdx = leftChildIdx;// let left is min

        if (rightChildIdx < minHeap.size() && minHeap.get(rightChildIdx) < minHeap.get(leftChildIdx)) {
            minChildIdx = rightChildIdx;
        }

        if (minHeap.get(parentIdx) > minHeap.get(minChildIdx)) {
            int temp = minHeap.get(minChildIdx);
            minHeap.set(minChildIdx, minHeap.get(parentIdx));
            minHeap.set(parentIdx, temp);
            heapifyAfterDelete(minChildIdx);
        }
    }

    // root ele to be deleted
    public int delete() {
        if (minHeap.size() == 0) {
            System.out.print("\nEmpty heap by delete method");
            return -1;
        }
        int del = minHeap.get(0);
        int lastIdx = minHeap.size() - 1;
        minHeap.set(0, minHeap.get(lastIdx));
        minHeap.remove(lastIdx);

        heapifyAfterDelete(0);

        return del;
    }

    public void printMinHeap() {
        if (minHeap.size() == 0) {
            System.out.print("\nEmpty heap by print method");
            return;
        }
        System.out.print("\nLevel order of heap : ");
        for (int i = 0; i < minHeap.size(); i++) {
            System.out.print(minHeap.get(i) + "  ");
        }
    }

}

public static void main(String[] args) {

    MinHeap minH = new MinHeap();
    minH.add(4);
    minH.add(-3);
    minH.add(-10);
    minH.add(10);
    minH.add(15);
    // System.out.println(minH.peek());
    minH.printMinHeap();
    minH.delete();
    minH.delete();
    minH.delete();
    minH.delete();
    minH.delete();
    minH.delete();
    // System.out.println(minH.peek());
    minH.printMinHeap();
}