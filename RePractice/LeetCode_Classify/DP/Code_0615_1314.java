package RePractice.LeetCode_Classify.DP;

public class Code_0615_1314 {
    //二维前缀和
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        //这里边界用 padding的话 后面不知道怎么处理了！！ 而且padding的意思 he那个前缀和真的还没怎么搞懂！
        //老老实实处理边界把
        int[][] f = new int[m][n];

        for (int i = 0; i < m;i++){
            for (int j = 0;j < n;j++){
                if (i == 0 && j == 0){
                    f[i][j] = mat[i][j];
                } else if (i == 0){
                    f[i][j] = f[i][j - 1] + mat[i][j];
                }else if (j == 0){
                    f[i][j] = f[i - 1][j] + mat[i][j];
                }else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1] - f[i - 1][j - 1] + mat[i][j];
                }

            }
        }

        int[][] res = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                int x1 = Math.max(0,i - K);
                int y1 = Math.max(0,j - K);
                int x2 = Math.min(m - 1,i + K);
                int y2 = Math.min(n - 1,j + K);
                if (x1 == 0 && y1 == 0){
                    res[i][j] = f[x2][y2];
                }else if (x1 == 0){
                    res[i][j] = f[x2][y2] - f[x2][y1 - 1];
                }else if (y1 == 0){
                    res[i][j] = f[x2][y2] - f[x1 - 1][y2];
                }else {
                    res[i][j] = f[x2][y2] - f[x2][y1 - 1] - f[x1 - 1][y2] + f[x1 - 1][y1 - 1];
                }

            }
        }
        return res;
    }
}
