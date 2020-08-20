package RePractice.NewPractice_7022;

import java.util.Stack;

public class Code_String_0728_9 {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int temp = x;
        int len = 0;
        while (temp > 0){
            temp /= 10;
            len++;
        }
        int[] nums = new int[len];
        temp = x;
        for (int i = 0;i < len;i++){
            nums[i] = temp % 10;
            temp /= 10;
        }

        int left = 0, right = len - 1;
        while (left < right){
            if (nums[left] != nums[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
