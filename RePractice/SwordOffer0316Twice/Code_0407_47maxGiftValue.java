package RePractice.SwordOffer0316Twice;

public class Code_0407_47maxGiftValue {
    //状态表示f[i][j] 表示 i，j 位置上最大礼物价值
    //状态计算 f[i][j] = max (f[i-1][j],f[i][j-1]) + gift[i][j];
    //
    //

    //正常思路做法！
    public int solution(int[][] grid){
        if (grid == null || grid.length < 1 || grid[0].length < 1){
            return 0;
        }
        //为啥又超出边界了？
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] f = new int[rows+1][cols+1];
        f[0][0] = grid[0][0];
        //然后还要f[i][0]  f[0][j]的边界
        //只能从上
        for (int i = 1;i <= rows; i++){
            f[i][0] = f[i-1][0] + grid[i][0];
        }
        //只能左边
        for (int j = 1; j <= cols;j++){
            f[0][j] = f[0][j-1] + grid[0][j];
        }

        for (int i = 1 ; i <= rows ; i++){
            for (int j = 1; j <= cols; j++){
                f[i][j] = Math.max(f[i-1][j] , f[i][j-1]) + grid[i][j];
            }
        }
        return f[rows][cols];
    }

    //正常思路做法！
    public int solution3(int[][] grid){
        if (grid == null || grid.length < 1 || grid[0].length < 1){
            return 0;
        }
        //为啥又超出边界了？
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] f = new int[rows][cols];
        f[0][0] = grid[0][0];
        //然后还要f[i][0]  f[0][j]的边界
        //只能从上
        for (int i = 1;i < rows; i++){
            f[i][0] = f[i-1][0] + grid[i][0];
        }
        //只能左边
        for (int j = 1; j < cols;j++){
            f[0][j] = f[0][j-1] + grid[0][j];
        }

        for (int i = 1 ; i < rows ; i++){
            for (int j = 1; j < cols; j++){
                f[i][j] = Math.max(f[i-1][j] , f[i][j-1]) + grid[i][j];
            }
        }
        return f[rows - 1][cols - 1];
    }










    //这种做法没太搞懂！！acwing上de
    //边界情况f[i][0] = f[0][j] = 0
    public int solution2(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] f = new int[rows + 1][cols + 1];
        //为啥这个边界直接不用写了！
        //f[0][0] = grid[0][0];
        //从1 开始计算， 这样就不用处理边界问题了 ， 从1开始， i-1就是0 不会越界
        // i < rows 少了<=
        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= cols; j++){
//                f[i][j] = Math.max(f[i -1][j],f[i][j-1]) + arr[i][j];
                //为什么是i- 1 j - 1 ，因为是从 i = 1 开始计算的，所以要偏移一位！
                f[i][j] = Math.max(f[i -1][j],f[i][j-1]) + grid[i - 1][j - 1];
            }
        }
        return f[rows][cols];
    }
}
