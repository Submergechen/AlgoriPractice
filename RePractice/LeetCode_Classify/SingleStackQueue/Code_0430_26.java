package RePractice.LeetCode_Classify.SingleStackQueue;

public class Code_0430_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int k = 1;
        for (int i = 1; i < nums.length ;i++){
            if (nums[i] != nums[i - 1]){
                nums[k++] = nums[i];
            }

        }
        return k;
    }
}
