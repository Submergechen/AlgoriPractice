package RePractice.LeetCode_Classify.BoYiLun;

public class Code_0616_486 {
    //博弈问题
    //dp
    public boolean PredictTheWinner2(int[] nums) {
        if (nums == null || nums.length < 1){
            return true;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0;i < len;i++){
            dp[i][i] = nums[i];
        }
        for (int l = 2;l <= len;l++){
            for (int i = 0;i < len - l + 1;i++){
                int j = i + l - 1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j] , nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len - 1] >= 0;
    }
    //递归递归！
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length < 1){
            return true;
        }
        return dfs(nums,0,nums.length - 1) > 0;
    }

    public int dfs(int[] nums, int l ,int r){
        //只剩下一堆了！！
        if (l == r){
            return nums[l];
        }
        return Math.max(nums[l] - dfs(nums,l + 1, r) , nums[r] - dfs(nums,l , r - 1));
    }

    //记忆化搜索
    int[][] m;
    public boolean PredictTheWinner1(int[] nums) {
        if (nums == null || nums.length < 1){
            return true;
        }
        m = new int[nums.length][nums.length];
        for (int i = 0;i < nums.length;i++){
            for (int j = 0;j < nums.length;j++){
                m[i][j] = Integer.MIN_VALUE;
            }
        }
        //这里是>=0 ，分数一样 也是玩家1赢！
        return dfs1(nums,0,nums.length - 1) > 0;
    }

    public int dfs1(int[] nums, int l ,int r){
        //只剩下一堆了！！
        if (l == r){
            return nums[l];
        }
        if (m[l][r] == Integer.MIN_VALUE){
            m[l][r] = Math.max(nums[l] - dfs(nums,l + 1, r) , nums[r] - dfs(nums,l , r - 1));
        }
        return m[l][r];
    }

}
