package RePractice.LeetCode_Classify.Binary;

public class Code_0415_1_69 {
    //首先这个题 可以确定边界， 根号x的值，  边界就是 1  ----  x
    //为什么这个题 只可以用第二种模版，第一种模版不可以吗？
    public int solution(int x){
        int l = 0 ;
        long r = x;
        while (l < r){
            //而且这里r有可能溢出，当r是最大整数的时候，会溢出
            int middle = (int) (l + r + 1 >> 1);
            //midlle *middle 也可能溢出，所以改成 middle >= x / middle
            if (middle  <= x / middle){
                l = middle;
            }else {
                r = middle - 1;
            }
        }
        return (int)r;
    }
}
