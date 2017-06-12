/**
 * Created by hbgtjxzbbx on 17-6-6.
 */
import java.util.List;
public interface Map61B<K,V> {
    boolean containKey(K key);
    V get(K key);
    int size();
    void put(K key, V value);
    List<K> keys();

}
