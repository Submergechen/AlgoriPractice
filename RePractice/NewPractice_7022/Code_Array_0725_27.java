package RePractice.NewPractice_7022;

public class Code_Array_0725_27 {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != val){
                nums[res++] = nums[i];
            }
        }
        return res;
    }

}
