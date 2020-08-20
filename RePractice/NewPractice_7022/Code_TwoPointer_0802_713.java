package RePractice.NewPractice_7022;

public class Code_TwoPointer_0802_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int res = 0;
        int tempV = 1;
        for (int i = 0;i < n;i++){
            if (nums[i] >= k){
                start = i + 1;
                tempV = 1;;
            }else {
                tempV *= nums[i];
                while (tempV > k && start < n){
                    tempV /= nums[start];
                    start++;
                }
            }
            if (tempV < k){
                res += i - start + 1;
            }
        }
        return res;
    }
    //写的乱七八糟
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int right = 0,n = nums.length;
        int temp = 1;
        while (left < n && right < n){
            if (temp * nums[left + 1] < k){
                temp *= nums[left];
            }
            if (temp < k){
                res++;
                if (temp * nums[left + 1] < k){
                    left++;
                }

            }else {
                temp /= nums[right];
                right++;
                res++;
                left++;

            }

        }
    }


}
