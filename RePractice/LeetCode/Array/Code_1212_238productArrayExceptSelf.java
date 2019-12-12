package RePractice.LeetCode.Array;

public class Code_1212_238productArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length ; i++){
            if (i == 0){
                left[i] = 1;
                right[nums.length - i - 1] = 1;
            }else {
                left[i] = nums[i - 1] * left[i - 1];
                right[nums.length - 1- i] = nums[nums.length  - i] * right[nums.length - i];
            }


        }

        for (int i = 0; i < nums.length ; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
