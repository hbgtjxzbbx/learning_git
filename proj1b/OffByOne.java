/**
 * Created by hbgtjxzbbx on 17-5-27.
 */
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y){
        if(Math.abs((int)x-(int)y)==1){
            return true;
        }else{
            return false;
        }
    }
}