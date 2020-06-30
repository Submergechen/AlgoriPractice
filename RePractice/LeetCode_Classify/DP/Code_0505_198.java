package RePractice.LeetCode_Classify.DP;

public class Code_0505_198 {

    public int rob1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int res = 0;
        int len = nums.length;
        int[] f = new int[len];
        int[] g = new int[len];

        for (int i = 0;i < len;i++ ){
            f[0] = nums[0];
            g[0] = 0;
            if (i >= 1){
                f[i] = g[i - 1] + nums[i];
                g[i] = Math.max(f[i - 1] , g[i - 1]);
            }
            res = Math.max(res , Math.max(f[i],g[i]));
        }
        return res;
    }


































    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+1];
        int[] g = new int[n+1];
        for (int i = 1;i <= n;i++){
            f[i] = Math.max(f[i-1],g[i-1]);
            g[i] = f[i-1] + nums[i-1];
        }
        return Math.max(f[n],g[n]);
    }
}
