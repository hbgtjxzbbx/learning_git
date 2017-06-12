import java.util.Map;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by hbgtjxzbbx on 17-6-6.
 */
public class MapHelper {
    public static <K,V> V get(Map61B<K,V> sim, K key){
        if(sim.containKey(key)){
            return sim.get(key);
        }
        return null;
    }
    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
        List<K> keylist =map.keys();
        K largest= keylist.get(0);
        for(K k: keylist){
            if(k.compareTo(largest)>0){
                largest=k;
            }
        }
        return largest;
    }
    @Test
    public void testGet(){
        Map61B<String, Integer> m = new ArrayMap<>();
        m.put("horse",3);
        m.put("fish",9);
        Integer actual = get(m,"fish");
        Integer expected =9;
        assertEquals(expected, actual);
        assertEquals(null, get(m, "ewwafas"));
    }

}
