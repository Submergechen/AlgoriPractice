package RePractice.NewPractice_7022;

public class Code_DP_0811_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        sum /= 2;
        return helper(nums,0,sum);
    }

    public boolean helper(int[] nums, int index , int target){
        if (target == 0){
            return true;
        }
        if (index == nums.length || target < 0){
            return false;
        }
        if (helper(nums,index + 1 ,target - nums[index])){
            return true;
        }
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]){
            j++;
        }
        return helper(nums,j,target);
    }


    //dp
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        sum /= 2;
        //前i个元素能否构成 sum
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0;i <= len;i++){
            dp[i][0] = true;
        }

        for (int i = 1;i <= len;i++){
            for (int j = 0;j <= sum;j++){
                //不加
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }

            }
            if (dp[i][sum] == true){
                return true;
            }
        }
        return dp[len][sum];

    }




}
