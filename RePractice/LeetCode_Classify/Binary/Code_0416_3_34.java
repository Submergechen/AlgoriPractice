package RePractice.LeetCode_Classify.Binary;
/**
 * 第三题
 */
public class Code_0416_3_34 {
    public int[] solution(int[] nums , int target){
        if (nums == null || nums.length < 1){
            return new int[]{-1,-1};
        }
        int l = 0 , r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        //有可能是不存在的！
        //如果写成>就错了，有可能是小于的，最后一个数也小于！
//        if (nums[r] > target){
//            return new int[]{-1,-1};
//        }
        if (nums[r] != target){
            return new int[]{-1,-1};
        }
        int start = r;
        l = 0;
        r = nums.length - 1;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        int end = r;
        return new int[]{start,end};

    }
}
