package RePractice.SwordOffer0316Twice.Dp;
//暴力解法
public class Code_0325_01bag {
    //n 种物体， 最大不超过m

    public int solution(int[] v , int[] w , int n ,int m){
        int[][] f = new int[n][m];
        for (int i = 1 ; i <= n ; i ++){
            for (int j = 0; j <= m; j++){
                //临界条件，包不包括第i种物体
                f[i][j] = f[i-1][j];
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i-1][j] , f[i-1][j-v[i]] + w[i]);
                }
            }
        }
        return f[n][m];
    }
}
