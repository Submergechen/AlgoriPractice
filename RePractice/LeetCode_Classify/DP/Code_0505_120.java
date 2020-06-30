package RePractice.LeetCode_Classify.DP;

import java.util.List;

//第二题

public class Code_0505_120 {
    //最容易理解de方法
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] f = new int[n][n];
        //初值！
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1;i < n;i++){
            for (int j = 0;j <= i;j++){
                //左上角
                f[i][j] = Integer.MAX_VALUE;
                if (j > 0){
                    f[i][j] = Math.min(f[i][j],f[i-1][j-1] + triangle.get(i).get(j));

                }
                //右上角
                if (j < i){
                    f[i][j] = Math.min(f[i][j],f[i-1][j] + triangle.get(i).get(j));

                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0;k < n;k++){
            res = Math.min(res,f[n-1][k]);
        }
        return res;
    }
    //滚动数组来优化！
    public int minimumTotal1(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] f = new int[2][n];
        //初值！
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1;i < n;i++){
            for (int j = 0;j <= i;j++){
                //左上角
                f[i & 1][j] = Integer.MAX_VALUE;
                if (j > 0){
                    f[i & 1][j] = Math.min(f[i & 1][j],f[i-1 & 1][j-1] + triangle.get(i).get(j));

                }
                //右上角
                if (j < i){
                    f[i & 1][j] = Math.min(f[i & 1][j],f[i-1 & 1][j] + triangle.get(i).get(j));

                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0;k < n;k++){
            res = Math.min(res,f[n-1 & 1][k]);
        }
        return res;
    }
}


//比较好的方法
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        for(int i=len-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                if(i == len-1)
                    dp[i][j] = triangle.get(i).get(j);
                else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
