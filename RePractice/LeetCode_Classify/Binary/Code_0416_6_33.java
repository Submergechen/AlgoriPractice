package RePractice.LeetCode_Classify.Binary;

/**
 * 第6题s
 */
public class Code_0416_6_33 {
    public int solution(int[] nums , int target){
        if (nums == null || nums.length < 1){
            return -1;
        }
        //找最小值
        int l = 0 , r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] <= nums[nums.length - 1]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        //判断在哪一段区间内
        if (target <= nums[nums.length - 1]){
            r = nums.length - 1;
        }else {
            l = 0;
            r--;
        }
        while (l < r ){
            int mid = l + r >> 1;
            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        //r有可能小于0 ？
//        if (nums[r] == target){
//            return r;
//        }
        if (nums[l] == target){
            return l;
        }
        return -1;
    }
}
