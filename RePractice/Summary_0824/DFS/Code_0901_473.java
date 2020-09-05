package RePractice.Summary_0824.DFS;

public class Code_0901_473 {
    boolean[] st;
    public boolean makesquare(int[] nums) {
        int n = nums.length;
        int sum = 0;
        st = new boolean[n];
        for (int num : nums){
            sum += num;
        }
        if (sum == 0 || sum % 4 != 0){
            return false;
        }
        return dfs(nums,0,0,sum / 4);
    }

    public boolean dfs(int[] nums, int cur ,int u ,int length){
        if (cur == length){
            u++;
            cur = 0;
        }
        if (u == 4){
            return true;
        }
        for (int i = 0;i < nums.length;i++){
            if (!st[i] && cur + nums[i] <= length){
                st[i] = true;
                if (dfs(nums,cur + nums[i],u,length)){
                    return true;
                }
                st[i] = false;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }
        return false;
    }
}
