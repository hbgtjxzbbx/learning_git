/**
 * Created by hbgtjxzbbx on 17-5-27.
 */
import static org.junit.Assert.*;
import org.junit.Test;
public class TestPalindrome {
    @Test
    public void testwordDeque(){
        String a="hello world";
        Deque<Character> charDeqa= Palindrome.wordToDeque(a);
        String b="wangduduududgnaw";
        Deque<Character> charDeqb= Palindrome.wordToDeque(b);
        charDeqa.printDeque();
        System.out.println(a);
        charDeqb.printDeque();
        System.out.println(b);
        assertEquals(Palindrome.isPalindrome(a),false);
        assertEquals(Palindrome.isPalindrome(b),true);
    }
    @Test
    public void testEqualChar(){
        CharacterComparator charComp=new OffByOne();
        assertTrue(charComp.equalChars('c','d'));
        assertFalse(charComp.equalChars('e','h'));
    }

    @Test
    public void testwordDeque2() {
        String a = "flake";
        CharacterComparator ccFunc=new OffByOne();
        Deque<Character> charDeqa = Palindrome.wordToDeque(a);
        String b = "short";
        Deque<Character> charDeqb = Palindrome.wordToDeque(b);
        assertTrue(Palindrome.isPalindrome(a,ccFunc));
        assertFalse(Palindrome.isPalindrome(b,ccFunc));
    }

}
