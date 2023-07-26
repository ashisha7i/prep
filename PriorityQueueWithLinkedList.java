public class PriorityQueueWithLinkedList {
    public static void main(String[] args) {
        PriorityQ q = new PriorityQ();
        q.add(new QNode(10));
        q.add(new QNode(11));
        q.add(new QNode(12));
        q.add(new QNode(13));
        q.add(new QNode(14));
        q.add(new QNode(15));

        System.out.println(q.printQueue());
        System.out.println(q.getSize());
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

    public void add(QNode node) {
        if(head == null) {
            head = node;
            this.size++;
        } else {
            QNode start = head;
            while(true) {
                QNode next = start.getNext();
                if(next == null) { // Last node - add the new node here
                    start.setNext(node);
                    this.size++;
                    break;
                } else {
                    start = start.getNext();
                }
            }
        }
    }


    public int getSize() {
        return this.size;
    }

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
