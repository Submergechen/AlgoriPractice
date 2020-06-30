package RePractice.LeetCode_Classify.DP;

public class Code_0505_300 {


    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        for (int i = 0;i <len;i++){
            f[i] = 1;
            for (int j = 0; j < i;j++){
                if (nums[j] < nums[i]){
                    f[i] = Math.max(f[i] , f[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0;  i < len;i++){
            res = Math.max(res,f[i]);
        }
        return res;
    }






























    public int lengthOfLIS(int[] nums) {
         int n = nums.length;
         int[] f = new int[n];

         for (int i = 0;i <n; i++){
             //谁都不包括de情况
             f[i] = 1;
             for (int j = 0;j < i;j++){
                 if (nums[j] < nums[i]){
                     f[i] = Math.max(f[i],f[j] + 1);
                 }
             }
         }
        int res = 0;
         for (int i = 0;i < n;i++){
             res = Math.max(f[i],res);
         }
         return res;
    }

}
