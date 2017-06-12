import org.junit.Test;

/**
 * Created by hbgtjxzbbx on 17-6-8.
 */
public class testSrc {
    @Test
    public void testHistMap(){
            HistoryMap<String, Integer> h = new HistoryMap<>();
            h.put("party", 1);
            h.put("parrot", 2);
            h.put("conga", 4);
            h.put("parrot", 3);
            h.undo();
            h.undo();
            System.out.println(h);
// Output: {parrot=2, party=1}
            h.remove("party");
            h.undo();
            System.out.println(h);
// Output: {parrot=2, party=1}
        }
    }
