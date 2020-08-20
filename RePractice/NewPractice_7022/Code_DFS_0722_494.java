package RePractice.NewPractice_7022;

//必须顺序！ 所以不能用那种 这个位置放哪一个数！ 只能第一个位置放第一个数！
public class Code_DFS_0722_494 {
    boolean[] st;
    int n;
    int res = 0;
    int target;
    public int findTargetSumWays(int[] nums, int S) {

        n = nums.length;
        st = new boolean[n];
        target = S;
        dfs(nums,0,0);
        return res;
    }

    public void dfs(int[] nums,int index ,int temp){

        if (index == n){
            if (temp == target){
                res ++;
            }
            return;
        }

        dfs(nums,index + 1 ,temp + nums[index]);
        dfs(nums,index + 1 ,temp - nums[index]);


    }

}


public class Solution {
    int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return result;
        helper(nums, S, 0, 0);
        return result;
    }

    public void helper(int[] nums, int target, int pos, long eval){
        if (pos == nums.length) {
            if (target == eval) result++;
            return;
        }
        helper(nums, target, pos + 1, eval + nums[pos]);
        helper(nums, target, pos + 1, eval - nums[pos]);
    }
}
