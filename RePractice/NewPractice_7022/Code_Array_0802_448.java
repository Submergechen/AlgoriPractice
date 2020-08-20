package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code_Array_0802_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ;i < nums.length;i++){
            while (nums[nums[i] - 1] != nums[i]){
                swap(nums,i,nums[i] - 1);
            }
        }
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != i + 1){
                res.add(i + 1);
            }
        }
        return res;
    }

    public void swap(int[] nums , int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
