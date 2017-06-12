/**
 * Created by hbgtjxzbbx on 17-5-18.
 */
public class ArrayDeque<T> {
    public int size=0;
    public int senIndex;
    public int maxSize=4;
    public T[] array;

    public int vaildIndex(int index){
        return (index+maxSize)%maxSize;
    }
    public int getFirstIndex(){
        return vaildIndex(senIndex);
    }
    public int getFirstPrevIndex(){
        return vaildIndex(senIndex-1);
    }
    public int getLastIndex(){
        return vaildIndex(senIndex+size-1);
    }
    public int getFirstPostIndex(){
        return vaildIndex(senIndex+1);
    }
    public int getLastPostIndex(){
        return vaildIndex(senIndex+size);
    }


    // just for fun
//    public Integer [] arrayFun= (Integer[]) new Object [16];

    public ArrayDeque(){
        senIndex=0;
        array=(T[]) new Object [maxSize];
    }
    public int size(){
        return size;
    }
    public void addFirst(T val){
        if(size==maxSize){
            T[] arrayNew=(T[]) new Object[maxSize*2];
            System.arraycopy(array,senIndex,arrayNew,1,maxSize-senIndex);
            System.arraycopy(array,0,arrayNew,1+maxSize-senIndex,senIndex);
            arrayNew[0]=val;
            senIndex=0;
            array=arrayNew;
            maxSize=maxSize*2;
            size=size+1;
        }
        else{
        senIndex=getFirstPrevIndex();
        array[senIndex]=val;
        size=size+1;
        }
    }
    public void addLast(T val){
        if (size==maxSize){
            T[] arrayNew=(T[]) new Object[maxSize*2];
            System.arraycopy(array,senIndex,arrayNew,0,maxSize-senIndex);
            System.arraycopy(array,0,arrayNew,maxSize-senIndex,senIndex);
            arrayNew[maxSize]=val;
            senIndex=0;
            array=arrayNew;
            maxSize=maxSize*2;
            size=size+1;
        }
        else{
            int index=getLastPostIndex();
            array[index]=val;
            size=size+1;
        }
    }
    public T removeFirst(){
        if(size>0) {
            T result = array[senIndex];
            senIndex = getFirstPostIndex();
            size = size - 1;
            if ((float) size / maxSize < 0.25 & size>4) {
                cutSize();
            }
            System.out.println(result);
            return result;
        }
        else
            return null;
    }

    public T removeLast(){
        if(size>0) {
            int index = getLastIndex();
            T result = array[index];
            size = size - 1;
            if ((float) size / maxSize < 0.25 & size>4) {
                cutSize();
            }
            System.out.println(result);
            return result;
        }
        else
            return null;
    }
    public T get(int index){
        if (index>=size|index<0) {
            return null;
        }
        else{
            return array[vaildIndex(senIndex+index)];

        }

    }
    public void printArray(){
        for(int i=0;i<size;i++) {
            System.out.print(get(i)+" ");
        }
        System.out.println();
    }


    public void cutSize(){
        int sizeNew=maxSize/4;
        T[] arrayNew=(T[]) new Object[sizeNew];
        int firstPart=Math.min(maxSize-senIndex,size);
        int secPart= Math.min(size-firstPart,0);
        System.arraycopy(array,senIndex,arrayNew,0,firstPart);
        System.arraycopy(array,0,arrayNew,firstPart,secPart);
        senIndex=0;
        array=arrayNew;
        maxSize=maxSize/4;

    }

    public boolean isEmpty(){
        return size==0;
    }



}
