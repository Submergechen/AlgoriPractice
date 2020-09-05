package RePractice.Summary_0824.Array;

public class Code_0826_27 {
    public int remove(int[] nums,int val){
        int k = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;

    }
}
