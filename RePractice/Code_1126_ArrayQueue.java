package RePractice;

public class Code_1126_ArrayQueue {
    private Integer arr[];
    private Integer size;
    private Integer start;
    private Integer end;

    public Code_1126_ArrayQueue(Integer initSize) {
        if (initSize < 0){
            throw new IllegalArgumentException("初始值小于0");
        }
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    public void push(int obj){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("full");
        }
        size++;
        arr[end] = obj;
        end = end == arr.length - 1 ? 0 : end + 1 ;

    }

    public Integer peek(){
        if (size == 0){
            return null;
        }
        return arr[start];
    }

    public Integer pool(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("empty");
        }
        size--;
        int temp = arr[start];
        start = start == arr.length - 1? 0 : start + 1;
        return temp;
    }
}
