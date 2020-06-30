package RePractice.LeetCode_Classify.Binary;

/**
 * 5
 */
public class Code_0416_5_153 {
    public int solution(int[] nums){
//        if (nums == null){
//            return 0;
//        }
        int l = 0 , r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] <= nums[nums.length - 1]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return nums[r];
    }
}
