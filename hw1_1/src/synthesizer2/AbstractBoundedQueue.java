package synthesizer2;

/**
 * Created by hbgtjxzbbx on 17-6-6.
 */

/**
 * Created by hbgtjxzbbx on 17-6-6.
 */
abstract class AbstractBoundedQueue<T> implements BoundedQueue2<T> {
    protected int fillCount;
    protected int capacity;
    public int capacity(){
        return capacity;
    }
    public int fillCount(){
        return fillCount;
    }
    public abstract T peek();
    public abstract T dequeue() throws Exception;
    public abstract void enqueue(T x);
}
