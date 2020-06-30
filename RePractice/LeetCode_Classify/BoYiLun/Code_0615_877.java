package RePractice.LeetCode_Classify.BoYiLun;

//博弈！！ 这个
public class Code_0615_877 {

    int[][] m;
    public boolean stoneGame(int[] piles) {
        //记忆化递归
        int len = piles.length;
        m = new int[len][len];
        for (int i = 0;i < len ;i++){
            for (int j = 0;j < len;j++){
                m[i][j] = Integer.MIN_VALUE;
            }
        }
        return dfs(piles,0,len - 1) > 0;
    }

    public int dfs(int[] piles , int l ,int r){
        if (l == r) return piles[l];
        if (m[l][r] == Integer.MIN_VALUE ){
            m[l][r] = Math.max(piles[l] - dfs(piles, l + 1 ,r) , piles[r] - dfs(piles,l,r - 1));
        }
        return m[l][r];
    }


    public boolean stoneGame1(int[] piles) {
        //dp
        int len = piles.length;
        int[][] dp = new int[len][len];
//        for (int i = 0;i < len ;i++){
//            for (int j = 0;j < len;j++){
//                dp[i][j] = Integer.MIN_VALUE;
//            }
//        }
        for (int i = 0;i < len;i++){
            dp[i][i] = piles[i];
        }
        for (int l = 2;l <= len;l++){
            for (int i = 0; i < len - l + 1;i++){
                int j = l + i - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j],piles[j] - dp[i][j - 1]);

            }
        }
        return dp[0][len-1] > 0 ;
    }




}
