package RePractice.Summary_0824;

import java.util.Scanner;

public class Code_0907_beike2 {

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        String str2 = sc.nextLine();
        String str1 = "";

        int n = str1.length();
        int m = str2.length();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0;i <= n;i++){
            dp[i][0] = i;
        }
        for (int i = 0;i <= m ;i++){
            dp[0][i] = i;
        }
        for (int i = 1;i <= m;i++){
            for (int j = 1;j <= m;j++){
                dp[i][j] = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(dp[i][j],dp[i / 2][j] + 1);
            }
        }

        System.out.println(n - 6);

    }
}
