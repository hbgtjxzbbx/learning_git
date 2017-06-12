/**
 * Created by hbgtjxzbbx on 17-6-6.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
public class DemoCollections {
    public static String cleanString(String s){
        return s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
    }
    public static List<String> getWords(String inputFilename){
        In in =new In(inputFilename);
        List<String> w= new ArrayList<String>();
        while(!in.isEmpty()){
            String rawString=in.readString();
            w.add(cleanString(rawString));
        }
        return w;
    }
    public static Set<String> findUniqueWords(List<String> words){
        Set<String> ss = new HashSet<String>();
        for(int i = 0; i < words.size(); i +=1){
            ss.add(words.get(i));
        }
        return ss;
    }
    public static Map<String, Integer> findWordCount(List<String> words,List<String> targets){
        Map<String,Integer> wordCount = new HashMap<>();
        for(int i = 0; i < targets.size(); i += 1) {
            wordCount.put(targets.get(i), 0);
        }
        for (int i = 0; i < words.size();  i +=1){
            String ithWord= words.get(i);
            if (wordCount.containsKey(ithWord)) {
                int oldCount= wordCount.get(ithWord);
                wordCount.put(ithWord,oldCount+1);
            }
        }
        return wordCount;
    }
    public static void main(String[] args) {
        List<String> w= getWords("libraryOfBabylon.txt");
        List<String> targets= new ArrayList<String>();
        targets.add("lottery");
        targets.add("the");
        targets.add("babylon");
        System.out.println(findWordCount(w,targets));
        System.out.println(findUniqueWords(w));

    }
}
