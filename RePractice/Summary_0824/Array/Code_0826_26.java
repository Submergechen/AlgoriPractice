package RePractice.Summary_0824.Array;

public class Code_0826_26 {
    public int remove(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int k = 1;
        for (int i = 1; i < nums.length;i++){
            if (nums[i - 1] != nums[i]){
                nums[k++] = nums[i];
            }
        }
        return k;

    }
}
