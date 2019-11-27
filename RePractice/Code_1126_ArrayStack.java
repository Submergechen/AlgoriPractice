package RePractice;

public class Code_1126_ArrayStack {
    private Integer arr[];
    private Integer index;

    public Code_1126_ArrayStack(int initSize){
        if (initSize < 0){
            throw new IllegalArgumentException("输入的数组大小小于0");
        }
        arr = new Integer[initSize];
        index = 0;
    }

    public void push(int obj){
        if (index == arr.length){
            throw new ArrayIndexOutOfBoundsException("full");
        }
        arr[index++] = obj;
    }

    public Integer peek(){
        if (index == 0){
            return null;
        }
        return arr[index-1];
    }

    public Integer pop(){
        if (index == 0){
            throw new ArrayIndexOutOfBoundsException("full");
        }
        return arr[--index];
    }
}
