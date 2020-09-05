package RePractice.Summary_0824.Binary;

public class Code_0827_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if (nums[r] != target){
            return new int[]{-1,-1};
        }
        int start = r;

        l = 0;
        r = nums.length - 1;
        while (l < r){
            int mid = l + r + 1>> 1;
            if (nums[mid] <= target){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return new int[]{start,r};

    }
}
