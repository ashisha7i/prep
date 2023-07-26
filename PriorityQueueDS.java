public class PriorityQueueDS {
    public static void main(String[] args) {
        MyPriorityQueue mpq = new MyPriorityQueue(10);
        mpq.insert(1);
        mpq.insert(3);
        mpq.insert(2);
        mpq.insert(5);
        mpq.insert(6);
        mpq.insert(4);
        mpq.insert(7);
        mpq.insert(8);
        mpq.insert(10);
        mpq.insert(9);

        while (!mpq.isEmpty()) {
            int num = mpq.poll();
            System.out.print(num + " ");
        }
        System.out.println("");
        
    }
}

/**
 * Implementing a priority queue with 'array'
 * We will need to account for the fact that the array size cannot be changed. We do this by:
 * - initialize the array by passing the 'size' as a constructor param
 * - keeping track of 'size' 
 * - keeping track of 'MAX' number of elements the array can hold
 * 
 * We will use the above variables to handle all operations (insert, peek, poll)
 */
class MyPriorityQueue {
    private final int MAX;
    private int[] arr;
    private int itemCount;

    public MyPriorityQueue(int size) {
        MAX = size;
        arr = new int[MAX];
        itemCount = 0;
    }

    public void insert(int data) {
        int i = 0;

        if (!isFull()) {
            if (itemCount == 0) {
                arr[itemCount++] = data;
            } else {
                // Start from the end
                for (i = itemCount - 1; i >= 0; i--) {
                    // If data to be inserted is larger - then shift existing item to right
                    if (data > arr[i]) {
                        arr[i + 1] = arr[i];
                    } else {
                        break;
                    }
                }
                
                // Insert the data
                arr[i + 1] = data;
                itemCount++;
            }
        }
    }

    public int size() {
        return itemCount;
    }

    public boolean isFull() {
        return this.itemCount == this.MAX;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public int peek() {
        return this.arr[itemCount - 1];
    }

    public int poll() {
        return arr[--itemCount];
    }

}