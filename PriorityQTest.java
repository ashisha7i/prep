import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PriorityQTest {

    PriorityQ pq = new PriorityQ();
    
    @BeforeEach
    public void init() {
        System.out.println("Before");
        pq.add(5);
        pq.add(6);
        pq.add(3);
        pq.add(2);
    }
    
    @Test
    public void testAdd() {
        System.out.println("Adds");
        pq.add(1);
        pq.add(7);
        pq.add(4);
        Assert.assertEquals("1 2 3 4 5 6 7", pq.printQueue());
        Assert.assertEquals(7, pq.size());
    }

    @Test
    public void testPoll() {
        System.out.println("Poll");
        Assert.assertEquals(2, pq.poll());
        Assert.assertEquals(3, pq.size()); // Poll should reduce the size of the list
    }

    @Test
    public void testPeek() {
        System.out.println("Peek test");
        Assert.assertEquals(2, pq.peek());
        Assert.assertEquals(4, pq.size()); // Peek should not change the size of queue
        pq.add(1);
        Assert.assertEquals(1, pq.peek());
        Assert.assertEquals(5, pq.size()); 
    }
}
