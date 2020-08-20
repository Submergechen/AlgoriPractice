package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_Array_0810_581 {

        public int findUnsortedSubarray(int[] nums) {
            int[] temp = nums.clone();
            Arrays.sort(nums);

            int len = nums.length;
            for (int i = 0;i < nums.length;i++){
                if (nums[i] == temp[i]){
                    len--;
                }else {
                    break;
                }
            }
            if (len == 0){
                return 0;
            }
            for (int j = nums.length - 1; j >= 0;j--){
                if (nums[j] == temp[j]){
                    len--;
                }else {
                    break;
                }
            }

            return len;
        }

}
