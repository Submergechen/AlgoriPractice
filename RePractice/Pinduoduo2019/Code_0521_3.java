package RePractice.Pinduoduo2019;

import java.util.Scanner;

public class Code_0521_3 {
    static int N = 2510;
    static int[] as = new int[N];
    static int[] bs = new int[N];
    static double mod = 1e9 + 7;
    public static void main(String[] agrs){
        int[][] f = new int[N][N];
        //前缀和！

        Scanner sc = new Scanner(System.in);

        char[] chars1 = sc.nextLine().trim().toCharArray();
        char[] chars2 =sc.nextLine().trim().toCharArray();
        int n = chars1.length;
        int m = chars2.length;
        get_prefix_sum(as,chars1,n);
        get_prefix_sum(bs,chars2,m);

        if (as[n - 1] + bs[m - 1] != 0){
            System.out.println(0);
        }else {
            //dp
            for (int i = 0;i < n;i++){
                for (int j = 0;j < m;j++){
                    //空字符串
                    if (i == 0 && j == 0){
                        f[i][j] = 1;
                    }else {
                        if (as[i] + bs[j] >= 0){
                            if (i != 0){
                                f[i][j] += f[i-1][j];
                            }
                            if (j != 0){
                                f[i][j] += f[i][j-1];
                            }
                            f[i][j] %= mod;
                        }
                    }
                }
            }
            System.out.println(f[n - 1][m - 1]);
        }
    }

    public static void get_prefix_sum(int[] sum, char[] str,int k){
    //前缀和！！怎么求
        for (int i = 0;i < k;i++){
            if (i == 0){
                if (str[i] == '('){
                    sum[i] = 1;
                }else {
                    sum[i] = -1;
                }
            }else {
                if (str[i] == '('){
                    sum[i] = sum[i-1] + 1;
                }else {
                    sum[i] = sum[i-1] - 1;
                }
            }

        }
//        for (int i = 0;i < k;i++){
//            if (str[i] == '('){
//                sum[i+1] = sum[i] + 1;
//            }else {
//                sum[i+1] = sum[i] - 1;
//            }
//        }
    }
}
