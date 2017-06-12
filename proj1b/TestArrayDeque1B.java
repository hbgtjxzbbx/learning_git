/**
 * Created by hbgtjxzbbx on 17-5-18.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    public static void main(String[] args) {

        jh61b.junit.TestRunner.runTests("all", TestArrayDeque1B.class);
        /* Helpful challenge: Modify this file so that it outputs the list of
           operations as a String. Use the OperationSequence class. */
    }

    @Test
    public  void TestFunc() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                sad2.addLast(i);
            } else {
                sad1.addFirst(i);
                sad2.addFirst(i);
            }
        }
        TestAddRem(sad1,sad2);
    }

    public static void TestAddRem(StudentArrayDeque sad1, ArrayDequeSolution sad2){

        sad1.printDeque();
        System.out.println();
        sad2.printDeque();
        Integer a=null; // only for confirm, in this case Integer is boxed type, so it can refer to null;
        Object tmp1=sad1.removeFirst();
        Object tmp2=sad2.removeFirst();

        assertEquals("Exception: error in removeLast the expected value is " +tmp1+"while the achieved the value is"+tmp2,tmp1,tmp2);
        tmp1=sad1.removeLast();
        tmp2=sad2.removeLast();
        int tmp=(int)tmp1;    // only for  confirm that Integer can be cast transform to type int
        assertEquals("Exception: error in removeLast the expected value is " +tmp1+"while the achieved the value is"+tmp2,tmp1,tmp2);
        sad1.addFirst(-10);
        sad2.addFirst(-10);
        assertEquals(sad1.removeLast(), sad2.removeLast());
        assertEquals(sad1.removeLast(), sad2.removeLast());
        tmp1=sad1.removeLast();
        tmp2=sad2.removeLast();
        // only this one works
        assertEquals("Exception: error in removeLast the expected value is " +tmp1+"while the achieved the value is"+tmp2,tmp1,tmp2);
        sad1.addLast(20);
        sad2.addLast(20);
        assertEquals(sad1.removeFirst(), sad2.removeFirst());
        assertEquals(sad1.removeFirst(), sad2.removeFirst());
        sad1.addFirst(-10);
        sad2.addFirst(-10);
        assertEquals(sad1.removeFirst(), sad2.removeFirst());

    }
}