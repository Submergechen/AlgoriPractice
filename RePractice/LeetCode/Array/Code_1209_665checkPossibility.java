package RePractice.LeetCode.Array;

public class Code_1209_665checkPossibility {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2){
            return true;
        }
        int res = 0;
        for (int i = 0; i < nums.length ; i++){
            if (nums[i] > nums[i+1]){
                if (i == 0 || i + 1 == nums.length -1){
                    res++;
                }else {
                    if (nums[i-1] > nums[i+1]){
                        nums[i+1] = nums[i];
                    }else if (nums[i-1] <= nums[i+1]){
                        nums[i] = nums[i-1];
                    }
                    res++;
                }
            }
            if (res > 1){
                break;
            }
        }
        if (res == 1 || res == 0){
            return true;
        }else {
            return false;
        }
    }
}
