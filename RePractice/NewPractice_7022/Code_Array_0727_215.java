package RePractice.NewPractice_7022;

import java.util.Arrays;

public class Code_Array_0727_215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null){
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


}
