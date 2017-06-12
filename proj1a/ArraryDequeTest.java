/**
 * Created by hbgtjxzbbx on 17-5-18.
 */
import static org.junit.Assert.*;
import org.junit.Test;
public class ArraryDequeTest {

    @Test
    public void TestAdd(){
        ArrayDeque<Integer> list1= new ArrayDeque<Integer>();
        list1.addFirst(20);
        list1.addLast(30);
        list1.addFirst(10);
        list1.addFirst(-10);
        list1.addLast(40);
        assertEquals(5,list1.size());
        assertEquals(-10,(int)list1.removeFirst());
        list1.printArray();
        assertEquals(40,(int)list1.removeLast());
        assertEquals(30,(int)list1.removeLast());
        assertEquals(20,(int)list1.removeLast());
        assertEquals(10,(int)list1.removeLast());
        assertEquals(null,list1.removeLast());
        list1.addLast(100);
        list1.addLast(200);
        list1.printArray();
        assertEquals(2,list1.size());
    }

    public static void main(String[] args){
        //TestAdd();
        jh61b.junit.TestRunner.runTests("all", ArraryDequeTest.class);
    }
}
