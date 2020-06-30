package RePractice.SwordOffer0316Twice;

import java.util.ArrayList;
import java.util.List;

public class Code_0413_57findContinuousSequence {
    //暴力做法是n的平方

    //因为是正整数序列，才有这个性质
    //好像之前也遇到过这种情况，都是正数的时候，指针往后移
    //但是由于是i j是单调的，可以优化成双指针的做法 优化成on的时间复杂度
    public List<List<Integer> > findContinuousSequence(int sum) {
        if (sum < 0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int left = 1 , right = 1, s = 1; left <= sum; ){
            while (s < sum){
                s += ++right;
                // 1 2 3  4 5
            }
            if (s == sum && right - left + 1 > 1){
                List<Integer> result = new ArrayList<>();
                for (int k = left; k <= right; k++  ){
                    result.add(k);
                }
                res.add(result);
            }
            s -= left;
            left++;
        }
        return res;
    }
}
