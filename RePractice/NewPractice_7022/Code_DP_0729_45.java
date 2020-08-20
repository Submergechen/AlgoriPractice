package RePractice.NewPractice_7022;

public class Code_DP_0729_45 {
    public int jump(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int n = nums.length;
        int curEnd = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0;i < n;i++){
            maxPosition = Math.max(maxPosition,i + nums[i]);
            if (i == curEnd){
                steps++;
                curEnd = maxPosition;
                if (curEnd > n - 1){
                    break;
                }
            }
        }
        return steps;
    }
    public int jump1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1;i < n;i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1;j >= 0;j--){

                if (dp[j] > 0 && j + nums[j] >= i){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[n - 1] - 1;
    }


}
