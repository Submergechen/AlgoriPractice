package RePractice.SwordOffer0316Twice;

public class Code_0325_15numberOf1 {
    // 1 一直左移， 移动32位后会变成0
    public int solution(int n ){
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((n & flag) == 1){
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
