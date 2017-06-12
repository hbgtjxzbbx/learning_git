import org.junit.Test;
import synthesizer2.*;

import static org.junit.Assert.*;

/**
 * Created by hbgtjxzbbx on 17-6-6.
 */
public class TestArrayRingBuffer {
    @Test
    public void testEnqueue(){
        ArrayRingBuffer<Integer> arb=new ArrayRingBuffer<>(5);
        arb.enqueue(1);
        arb.enqueue(2);
        Integer tValue1=arb.fillCount();
        assertEquals((Integer)2, tValue1);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        assertTrue(arb.isFull());
        Integer tValue2=arb.dequeue();
        assertEquals((Integer) 1, tValue2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);




    }


}
