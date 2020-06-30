package RePractice.SwordOffer0316Twice;

import java.util.ArrayList;
import java.util.List;

public class Code_0406_43numberOf1 {
    /**
     * 第一种方法 ， 一个个枚举 ，找每个数里的1
     * 第二张方法，找规律 abcdef
     * 比如 _ _  c _ _ _
     * 1. 前两位不是 ab， 取00 - (ab - 1) 种情况 *   000 - 999 (1000)  也就是 ab*1000
     * 2. 前两位是ab，那么就要分情况讨论，第一种 c是0 那么就是0 个1
     * 第二种 c是1 ，那么 后面三位是 000 -- def  也就是def+1 个1
     * 第三种 c大于1 ，那么后面三位就是 000 --  999 就是1000个1
     * @return
     */
    //复杂度是ologn的平方
    public int solution(int n){
        if (n == 0){
            return 0;
        }
        // 各数位拆开放在这个数组里面
        List<Integer> number = new ArrayList<>();
        while (n != 0){
            number.add(n % 10);
            n = n / 10;
        }
        int res = 0;
        for (int i = number.size() - 1; i >= 0; i--){
            //left 表示左边的数， right表示右边数 123456 left = 12 , right = 456
            // t表示位数，  1 10 1000
            int left = 0 ,right = 0 ,t = 1;
            for (int j = number.size() - 1; j > i ; j--){
                left = left * 10 + number.get(j);
            }
            for (int j = i - 1; j >= 0; j--){
                right = right * 10 + number.get(j);
                t *= 10;
            }
            //第一种情况， 0 - （ab -1） * 1000
            res += left * t;
            if (number.get(i) == 1){
                res += right + 1;
            }else if (number.get(i) > 1){
                res += t;
            }

        }
        return res;

    }
}
