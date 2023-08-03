public class PriorityQueueWithLinkedList {
    public static void main(String[] args) {
        PriorityQ q = new PriorityQ();
        System.out.println("# Adding: 10, 12, 14, 16");
        q.add(10);
        q.add(12);
        q.add(14);
        q.add(16);
        System.out.println("  > Queue: " + q.printQueue() + " / Size: " + q.getSize() + "\n");
        
        System.out.println("# Adding: 13, 11, 9, 15, 17 ");
        q.add(13);
        q.add(11);
        q.add(9);
        q.add(15);
        q.add(17);
        System.out.println("  > Queue: "+ q.printQueue() + " / Size: " + q.getSize() + "\n");
        

        System.out.println("Verifying 'poll' operations:");
        System.out.println(". Poll 1: " + q.poll());
        System.out.println(". Poll 2: " + q.poll());
        System.out.println(". Poll 3: " + q.poll());

        System.out.println("  > Queue: " + q.printQueue() + " / Size: " + q.getSize() + "\n");
        
    }
}

/**
 * Node class that will be used as a node for the simplistic linked list we are going to create
 */
class QNode {
    private int value;
    private QNode next;

    public QNode(int value, QNode next) {
        this.value = value;
        this.next = next;
    }

    public QNode(int value) {
        this(value, null);
    }

    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public QNode getNext() {
        return next;
    }
    
    public void setNext(QNode next) {
        this.next = next;
    }
}

class PriorityQ {
    private int size;
    private QNode head;

    /**
     * Add a new element to the queue
     * @param numToAdd
     */
    public void add(int numToAdd) {
        if(head == null) { // First Element
            head = new QNode(numToAdd, null); // There is no next node so we pass null
        } else {
            // If the already inserted value is greater than the value to be inserted
            // Make the new node as the head and point the next to the old head
            if(head.getValue() > numToAdd) {
                head = new QNode(numToAdd, head);
            } else {
                // Find the last node that is smaller than the value to be inserted
                QNode theNode = getLastSmallerNode(numToAdd);
                // Insert the new node after the last smaller node and point the next to the old next
                theNode.setNext(new QNode(numToAdd, theNode.getNext()));
            }
        }
        this.size++; // Increment the size
    }

    /**
     * Get the last node that is smaller than the value to be inserted
     * @param numToAdd
     * @return
     */
    private QNode getLastSmallerNode(int numToAdd) {
        QNode node = this.head;
        
        // Start from the head and iterate until the next node is null or the value is greater than the value to be inserted
        while(node.getNext() != null && node.getValue() <= numToAdd) {
            if(node.getNext().getValue() > numToAdd) {
                return node;
            }
            node = node.getNext();
        }

        return node;
    }

    /**
     * Poll the first element from the queue
     * @return
     */
    public int poll() {
        int val = head.getValue();
        
        if(head.getNext() != null) {
            this.head  = head.getNext();
            this.size--;
        }

        return val;
    }

    /**
     * Get the size of the queue
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Peek the first element from the queue (does not move the pointer)
     * @return
     */
    public int peek() {
        return head.getValue();
    }

    /**
     * Utility method to print the queue
     * @return
     */
    public String printQueue() {
        StringBuilder sb = new StringBuilder();
        QNode curr = head;
        while(curr.getNext() != null) {
            sb.append(curr.getValue() + " ");
            curr = curr.getNext();
        }
        
        // Handling the last node
        if(curr != null) {
            sb.append(curr.getValue());
        }

        return sb.toString();
    }

}
