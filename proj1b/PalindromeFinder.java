/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words");

        while (!in.isEmpty()) {
            String word = in.readString();
            CharacterComparator charComp=new OffByN(5);
            if (word.length() >= minLength && Palindrome.isPalindrome(word,charComp)) {
                System.out.println(word);
            }
        }
    }
} 
