package RePractice.LeetCode_Classify.Binary;

/**
 * 第二题
 */
public class Code_0416_35 {
    public int solution(int[] nums , int target){
        //用哪个模版，反正是看结果在哪个区间里面！！
        if (nums == null || nums[nums.length - 1] < target){
            return nums.length;
        }
        int l = 0 , r = nums.length - 1;
        while(l < r){
            int mid = l + r >> 1;
            // 改成nums[mid] < target 也是一样de，结果就在绿颜色de边界点 l = mid + 1 ，反正是看结果在哪个区间里面！！
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }
}
