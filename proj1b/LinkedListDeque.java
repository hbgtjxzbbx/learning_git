/**
 * Created by hbgtjxzbbx on 17-5-17.
 */
public class LinkedListDeque<T> implements Deque<T> {
    public class Node{
        public T value;
        public Node post;
        public Node pre;
        public Node(T val,Node prenode, Node postnode ){
            value=val;
            pre=prenode;
            post=postnode;
        }
    }
    private Node sentine;
    private int size=0;
    public LinkedListDeque(){
        sentine=new Node(null,null, null);
        sentine.post=sentine;
        sentine.pre=sentine;
        size=0;
    }
    public void addFirst(T val){
        Node newNode=new Node(val,sentine,sentine.post);
        sentine.post.pre=newNode;
        sentine.post=newNode;
        size+=1;
    }
    public void addLast(T val){
        Node lastNode= new Node(val,sentine.post, sentine);
        sentine.pre.post=lastNode;
        sentine.pre=lastNode;
        size+=1;
    }

    public boolean isEmpty() {
        if(size!=0)
            return false;
        else
            return true;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node iterNode=sentine.post;
        for (int i=0; i<size; i++){
            System.out.println(iterNode.value);
            iterNode=iterNode.post;
        }
    }
    public T removeFirst(){
        T value=sentine.post.value;
        sentine.post.post.pre=sentine;
        sentine.post=sentine.post.post;
        if(size>0)
            size-=1;
        return value;
    }
    public T removeLast(){
        T value=sentine.pre.value;
        sentine.pre.pre.post=sentine;
        sentine.pre=sentine.pre.pre;
        if (size>0)
            size-=1;
        return value;
    }
    public T get(int index){
        if (index>size-1)
            return null;
        else {
            Node iterNode=sentine.post;
            int i=0;
            while(i!=index) {
                iterNode=iterNode.post;
                i++;
            }
            return iterNode.value;

        }
    }
    public void insert(T value, int position){
        if (position>=0 & position<=size) {
            Node iter =sentine.post;
            int i = 0;
            while (i != position) {
                iter = iter.post;
                i++;
            }
            Node newItem = new Node(value, iter.pre, iter);
            iter.pre.post = newItem;
            iter.pre = newItem;
            size = size + 1;
        }
    }
}
