package RePractice.LeetCode_Classify.Binary;

public class Code_0416_278 {
    public int solution(int n ){
        //int 为最大值时！！
        int l = 0 ;
        long r = n;
        while ( l < r){
             int mid = (int)(l + r >> 1);
            if (isbD(mid)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return (int)r;
    }
}
