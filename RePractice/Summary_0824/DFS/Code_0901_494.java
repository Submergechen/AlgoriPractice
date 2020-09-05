package RePractice.Summary_0824.DFS;

public class Code_0901_494 {
    int target = 0;
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        target = S;
        dfs(nums,0,0);
        return res;
    }

    public void dfs(int[] nums, int index, int sum){
        if (index == nums.length){
            if (sum == target){
                res++;
            }
            return;
        }
        dfs(nums,index + 1,sum + nums[index]);
        dfs(nums,index - 1, sum - nums[index]);
    }
}
