/**
 * Created by hbgtjxzbbx on 17-5-31.
 */
public class HoFDemo {
    public static int doTwice(IntUnaryFunction f, int x){
        return f.apply(f.apply(x));
    }
    public static void main(String[] args){
        IntUnaryFunction tenx=new TenX();
        int m=doTwice(tenx,10);
        System.out.println(doTwice(tenx,10));
    }
}
