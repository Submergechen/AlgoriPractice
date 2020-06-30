package RePractice.Toutiao2019;

import java.util.Scanner;

public class Code_0601_1 {
    static int N = 10010;
    static int mod = 1000000007;
    static int[][] f = new int[N][N];
    public static void main(String[] agrs){
        int n ,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int h = 1;
        while (h * (h + 1) / 2 <= (n + m)){
            h++;
        }
        h--;

        f[0][0] = 1;
        for (int i = 1;i <= h;i++){
            for (int j = 0;j <= n;j++){
                f[i][j] = f[i - 1][j];
                if (j >= i){
                    f[i][j] += f[i - 1][j - i];
                }
            }
        }
        int res = 0;
        for (int i = 0;i <= n;i++){
            for (int j = 1;j <= h;j++){
                if (h * (h + 1) / 2 - i <= m){
                    res = (res + f[j][i])% mod;
                }
            }

        }
        System.out.println(h + res);

    }
}
