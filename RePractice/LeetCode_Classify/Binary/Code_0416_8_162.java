package RePractice.LeetCode_Classify.Binary;

/**
 * 第八题
 */
public class Code_0416_8_162 {
    public int solution(int[] nums){
        //为啥不用考虑边界值，是因为 当mid = 最后一个边界值的时候，由于mid的计算方式是下取整，
        //当mid ==  n - 1的时候， l 和 r 的值都是 n - 1，此时就相等，不会进入循环
        // 我自己觉得这个题，直接用简单de方法来做就好， 好像之前的ccf也遇到过这个题
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return r;
    }
}
