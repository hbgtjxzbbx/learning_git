/**
 * Created by hbgtjxzbbx on 17-5-27.
 */
public class Palindrome{
    public static Deque<Character> wordToDeque(String word){
        int stringLen=word.length();
        Deque<Character> deChar= new LinkedListDeque<>();
        for(int i=0; i< stringLen; i++) {
            deChar.addLast(word.charAt(i));
        }
        return deChar;

    }

    public static boolean isPalindrome(String word){
        int dequeSize=word.length();
        Deque<Character> deChar=wordToDeque(word);
        for (int i=0;i<dequeSize;i++){
            char up=deChar.get(i);
            char down=deChar.get(dequeSize-1-i);
            if(up!=down){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String word, CharacterComparator charComp){
        int dequeSize=word.length();
        Deque<Character> deChar=wordToDeque(word);
        for (int i=0;i<dequeSize/2;i++){
            char up=deChar.get(i);
            char down=deChar.get(dequeSize-1-i);
            if(!charComp.equalChars(up,down)){
                return false;
            }
        }
        return true;
    }


}
