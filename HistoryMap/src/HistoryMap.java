import java.util.HashMap;
import java.util.Stack;

/**
 * Created by hbgtjxzbbx on 17-6-8.
 */
public class HistoryMap<K,V> extends HashMap<K,V> {
    public Stack<Operation> hisStack;

    private class Operation{
        boolean isRemove;
        K key;
        V value;
        Operation(boolean isRemove,K key,V value){
            this.isRemove=isRemove;
            this.key=key;
            this.value=value;
        }
    }

    public HistoryMap(){
        hisStack=new Stack<Operation>();
    }

    public boolean containsKey(Object k){
        return super.containsKey(k);
    }
    public boolean isHisEmpty(){
        return hisStack.isEmpty();
    }

    public V put(K key, V value){
        hisStack.push(new Operation(containsKey(key),key,super.get(key)));
        super.put(key,value);
        return value;
    }
    public V remove(Object k){
        V reValue= super.remove(k);
        hisStack.push(new Operation(true,(K) k ,reValue));
        return reValue;
    }
    public void undo(){
        if (isHisEmpty())
            return;
        Operation op=hisStack.pop();
        if(op.isRemove)
            super.put(op.key,op.value);
        else
            super.remove(op.key);

    }

}
