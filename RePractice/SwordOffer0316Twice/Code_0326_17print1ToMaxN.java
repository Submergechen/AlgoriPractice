package RePractice.SwordOffer0316Twice;

public class Code_0326_17print1ToMaxN {
    public void solution(int n){
        if (n < 1){
            return;
        }
        char[] chars = new char[n];
        process(chars , n , 0);
    }

    public void process(char[] chars , int n ,int index){
        if (index == n){
            printRes(chars);
        }

        for (int i = 0; i < n; i++){
            chars[index] = (char) (i + 48);
            process(chars , n , index + 1);
        }
    }

    public void printRes(char[] chars){
        boolean isZero = true;
        for (int i = 0 ;i < chars.length; i++){
            if (chars[i] == '0' && isZero){
                //isZero = false; 可能后面还会有0   连续几个0出现
                continue;
            }
            if (chars[i] != '0'){
                //第一个不为0  就设置为false
                isZero = false;
                System.out.println(chars[i]);
            }
            if (chars[i] == '0' && !isZero){
                System.out.println(chars[i]);
            }
        }

    }
}
