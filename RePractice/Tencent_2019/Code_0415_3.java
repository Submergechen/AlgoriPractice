package RePractice.Tencent_2019;

import java.util.Scanner;

public class Code_0415_3 {
    /**
     * dp 一般都是最大最小值，方案数
     * f[i][j]表示走过i个怪兽，需要花费j个金币，战斗力之和最大值
     * 这个就好像是 最大价值一样的，战斗力之和最大！！
     * 数据量 i最大50 ，一个1金币或者2金币， 所以j最大是100
     *
     * 状态计算，一般是用热狗法，把集合划分成若干个小集合来计算，分为若干部分，分别求方案，然后看什么时候可以去实施！
     * 这里可以划分成，买通第i个怪兽的所有方案，和不买通第i个怪兽的方案
     * 第一个方案 是 f[i-1][j-pi] + di ，di是战斗力，pi是金币数，总共j个金币
     * 第二个方案 是 f[i-1][j]
     * dp里面一般两个方案，其中一个方案是有条件的！ 第一个方案是可以无条件进行的，直接买通就可以了
     * 但是第二个方案 必须保证不买第i个怪兽，战斗力之和大于第i个怪兽 才可以不买通 f[i-1][j] >= di
     *
     * 最后的结果是 f[n][1-2n]里 f[n][j] 第一个能走通的值的j 就是最小金币数，进行遍历
     */

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //金币值
        int[] p = new int[n + 5];
        //武力数
        long[] d = new long[n + 5];
        long[][] f = new long[n+5][n * 2 + 10];
        for (int i = 1 ; i <= n;i++){
            d[i] = sc.nextInt();
        }
        for (int i = 1; i <= n;i++){
            p[i] = sc.nextInt();
        }
        //数组初始化为-1

        for (int i = 0; i < f.length; i++){
            for (int j = 0;j < f[0].length;j++){
                f[i][j] = -1;
            }
        }
        f[0][0] = 0;
        for (int i = 1 ;i <= n; i++){
            for (int j = 1; j <= n * 2; j++){
                //买通第i个怪兽
                if (j >= p[i] &&f[i - 1][j - p[i]] != -1 ) f[i][j] = f[i - 1][j - p[i]] + d[i];
                //不买通第ige怪兽
                if (f[i - 1][j - p[i]] != -1  && f[i-1][j] >= d[i]) f[i][j] = Math.max(f[i][j],f[i-1][j]);
            }
        }
        int res = 0;
        for (int i = 1; i <= n*2; i++){
            if (f[n][i] != -1){
                res = i;
                break;
            }
        }
        System.out.println(res);

    }
}
