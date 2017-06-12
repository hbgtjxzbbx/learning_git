import java.util.List;
import java.util.ArrayList;
/**
 * Created by hbgtjxzbbx on 17-5-31.
 */
public class Table<T>{
    int colSize;
    int rowSize;
    ArrayList<Row> rows;
    Col[] cols;
    public Table(){
        colSize=0;
        rowSize=0;
        rows=new ArrayList<Row>();
        cols=new Col[20];
    }
}
