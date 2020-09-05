package RePractice.Summary_0824;

import java.util.Scanner;

public class Code_0902_qianxin1 {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0 && n <= 36){
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3;i <= n;i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            System.out.println(dp[n]);

        }else {
            System.out.println(0);
        }

    }
}
