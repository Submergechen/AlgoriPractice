package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Code_Array_0802_75 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums){
            if (num == 0){
                count[0]++;
            }else if (num == 1){
                count[1]++;
            }else {
                count[2]++;
            }
        }
        for (int i = 0;i < nums.length;i++){
            if (count[0] > 0){
                nums[i] = 0;
                count[0]--;
                continue;
            }
            if (count[1] > 0){
                nums[i] = 1;
                count[1]--;
                continue;
            }
            if (count[2] > 0){
                nums[i] = 2;
                count[2]--;
                continue;
            }

        }
    }
    public void sortColors1(int[] nums) {
        int[] count = new int[3];
        for (int i : nums){
            count[i]++;
        }
        int k = 0;
        for (int i = 0; i < 3;i++){
            while (count[i] > 0){
                nums[k++] = i;
                count[i]--;
            }
        }
    }
}
