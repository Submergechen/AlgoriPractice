package RePractice.Summary_0824.DP;

import java.util.Scanner;

public class Code_0828_JD1 {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = 2 * row - 1;
        int startRow = 0;
        int startCol = row - 1;
        int[][] dp = new int[row][col];
        for (int i = 1;i < row;i++){
            for (int j = 0;j < 2 * i - 1;j++){
                dp[i][j] = Math.max(Math.max(dp[i - 1][j],dp[i - 1][j - 1]),dp[i - 1][j + 1]);
            }
        }

    }
}
