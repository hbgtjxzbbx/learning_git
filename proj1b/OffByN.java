/**
 * Created by hbgtjxzbbx on 17-5-27.
 */
public class OffByN implements CharacterComparator{
    public int N;
    public OffByN(int n){
        N=n;
    }
    public boolean equalChars(char x, char y) {
        int charDis = x - y;
        if (Math.abs(charDis) == N)
            return true;
        else
            return false;
    }
}
