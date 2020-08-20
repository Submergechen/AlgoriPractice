package RePractice.NewPractice_7022;

public class Code_Array_0801_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int n = nums.length;
        int res = 0;
        for (int i = 0;i < n;i++){
            if (nums[i] != 0){
                nums[res++] = nums[i];
            }

        }
        while (res < n){
            nums[res] = 0;
        }

    }

}
