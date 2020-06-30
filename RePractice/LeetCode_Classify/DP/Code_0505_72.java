package RePractice.LeetCode_Classify.DP;

public class Code_0505_72 {
    //第七题
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] f = new int[n+1][m+1];
        //边界情况
        for (int i = 0;i <= n;i++) f[i][0] = i;
        for (int i = 0;i <= m;i++) f[0][i] = i;

        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= m;j++){
                f[i][j] = Math.min(f[i-1][j] ,f[i][j-1]) + 1;
                //由于chars1 chars2 下标从开始 所以要-1
                f[i][j] = Math.min(f[i][j],f[i-1][j-1] + (chars1[i - 1] != chars2[j - 1] ? 1 : 0));
            }
        }
        return f[n][m];
    }
}
