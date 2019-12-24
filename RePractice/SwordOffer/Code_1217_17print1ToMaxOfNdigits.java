package RePractice.SwordOffer;

public class Code_1217_17print1ToMaxOfNdigits {
    //第一种方法 ，递归
    public static void print1ToMaxN(int n){
        if (n < 1){
            throw new RuntimeException("数据错误");
        }

        char[] chars = new char[n];
        process(chars , 0 , n);

    }

    public static void process(char[] chars , int index , int n){
        if (index == n ){
            printRes(chars);
        }

        for (int i = 0 ; i < 10 ; i++){
            chars[index] = (char)(i+48);
            process(chars , index + 1 ,n);
        }
    }
    public static void printRes(char[] chars){
        boolean isZero = true;
        for (int i = 0; i < chars.length ; i++){
            if (chars[i] == 0 && isZero){
                continue;
            }
            if (chars[i] != 0){
                isZero = false;
                System.out.println(chars[i]);
            }
            if (chars[i] == 0 && !isZero){
                System.out.println(chars[i]);
            }

        }
    }

    public static void main(String[] args) {
        print1ToMaxN(2);
    }
}
