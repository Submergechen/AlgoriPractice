package RePractice.LeetCode_Classify.DP;

public class Code_0618_312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0;i < n;i++){
            dp[i][i] = nums[i];
        }
        for (int l = 2;l <= n;l++){
            for (int i = 0;i + l - 1 < n;i++){
                int j = i + l - 1;
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i;k < j;k++){
                    if (k == 0){
                        dp[i][j] = Math.max(dp[i][j],nums[k] * nums[k + 1]  + dp[k+1][j]);
                    }else if (k == n - 1){
                        dp[i][j] = Math.max(dp[i][j],nums[k] * nums[k - 1]  + dp[i][k - 1]);
                    }else {
                        dp[i][j] = Math.max(dp[i][j],nums[k] * nums[k - 1] * nums[k + 1] + dp[i][k - 1] + dp[k+1][j]);
                    }




                }

            }
        }
        return dp[0][n - 1];
    }
//正确答案
    public int maxCoins2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];

//        for (int i = 0;i < n;i++){
//            dp[i][i] = nums[i];
//        }
        for (int l = 1;l <= n;l++){
            for (int i = 0;i + l - 1 < n;i++){
                int j = i + l - 1;
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i;k <= j;k++){

                    int coins = nums[k] * getNum(nums,i - 1) * getNum(nums, j + 1);
                    coins += (i == k ? 0 : dp[i][k - 1]);
                    coins += (k == j ? 0 : dp[k + 1][j]);
                    dp[i][j] = Math.max(dp[i][j],coins);

                }

            }
        }
        return dp[0][n - 1];
    }

    public int getNum(int[] nums, int i){
        if (i == - 1 || i == nums.length){
            return 1;
        }
        return nums[i];
    }

    public int maxCoins1(int[] nums) {
        int n = nums.length + 2;
        int[][] dp = new int[n][n];
        int[] arr = new int[n];

        for (int i = 1;i < n - 1;i++){
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[n - 1] = 1;

        for (int i = 0;i < n;i++){
            dp[i][i] = arr[i];
        }
        for (int l = 2;l <= n;l++){
            for (int i = 1;i + l - 2 < n;i++){
                int j = i + l - 1;
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i;k < j;k++){

                    dp[i][j] = Math.max(dp[i][j],nums[k]*nums[k - 1] *nums[k+1] + dp[i][k - 1] + dp[k+1][j]);


                }

            }
        }
        return dp[1][n - 2];
    }
}
