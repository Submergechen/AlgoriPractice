package RePractice.ByteDance_2019_414;

import java.util.Scanner;

//状态dp
public class Code_0514_4 {
    static int N = 20 , M = 1 << N;
    static int n ;
    static int[][] f = new int[M][N];
    //输入数据
    static int[][] w = new int[N][N];

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                w[i][j] = sc.nextInt();
            }
        }

        //题目的意思 初始状态是在1号点 但是是从0--n-1来计算的 而不是1---n
        // i 的状态是 000000001  经历过1号点 最后回到0号点
        //其余所有点是正无穷
        for (int i = 0;i < M;i++){
            for (int j = 0;j < N;j++){
                w[i][j] = Integer.MAX_VALUE;
            }
        }
        f[1][0] = 0;
        //dp一下所有状态
        //现在的状态是不回到原点
        for (int i = 0;i < 1 << n;i++){
            for (int j = 0;j < n;j++){
                //只有最后i里面包含了j 才有可能最后处于j ,只有这种情况 才有做下去的必要
                if ((i >> j & 1) == 1){
                    //从k转移过来
                    for (int k = 0;k < n;k++){
                        if ((i - (1 << j) >> k & 1) == 1){
                            f[i][j] = Math.min(f[i][j] , f[i - (1 << j)][k] + w[k][j]);
                        }
                    }
                }
            }
        }
        //加上回到原点的情况
        //从每个城市走回原点
        int res = Integer.MAX_VALUE;
        //f[(1 << n) - 1][i]  第一维代表除了 原点 其余点都被访问过了 的情况！1 << n == 100000000 - 1  == 01111111
        for (int i = 0;i < n;i++){
            res = Math.min(res,f[(1 << n) - 1][i] + w[i][0]);
        }
        System.out.println(res);

    }
}
