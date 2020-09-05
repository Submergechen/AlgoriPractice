package RePractice.Summary_0824.Binary;

public class Code_0827_33 {
    public int searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] <= nums[nums.length - 1]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if (target < nums[nums.length - 1] ){
            r = nums.length - 1;
        }else {
            l = 0;
            r = r - 1;
        }

        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }

        if (nums[l] == target){
            return l;
        }else {
            return -1;
        }
    }
}
