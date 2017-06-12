import java.util.ArrayList;
import java.util.List;
import org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by hbgtjxzbbx on 17-6-6.
 */

public class ArrayMap<K,V> implements Map61B<K,V> {
    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap(){
        keys =(K[]) new Object[100];
        values=(V[]) new Object[100];
        int size=0;
    }
    private int keyIndex(K key){
        for(int i = 0; i < size; i +=1){
            if (keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
    public boolean containKey(K key){
        int index = keyIndex(key);
        return index > -1;
    }
    public void put(K key, V value){
        int index = keyIndex(key);
        if (index==-1){
            keys[size]=key;
            values[size]=value;
            size += 1;
            return;
        }
        values[index]=value;
    }
    public V get(K key){
        int index= keyIndex(key);
        if(index>=0){
            return values[index];
        }
        return null;
    }
    public int size(){
        return size;
    }
    public List<K> keys(){
        List<K> keyList = new ArrayList<K>();
        for(int i =0; i < keys.length; i += 1){
            keyList.add(keys[i]);
        }
        return keyList;
    }


}
