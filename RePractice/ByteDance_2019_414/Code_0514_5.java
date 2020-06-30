package RePractice.ByteDance_2019_414;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Code_0514_5 {
    //贪心+dp 过河问题
    static int N = 10010;
    static int n;
    static int[] a = new int[N];
    static int[] f = new int[N];

    public static void main(String[] agrs){
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T-- != 0 ){
            n = sc.nextInt();
            for (int i = 1; i <= n;i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            if (n <= 2){
                System.out.println(a[2]);
            }else {
                //多次数据
                f[n + 1] = 0;

                for (int i = n;i >= 4;i--){
                    //运一个人 a + y
                    f[i] = a[i] + a[2] + f[i + 1];
                    //运两个人
                    //x y z   z
                    //x y
                    //x a b   a b
                    // x z
                    if (i + 1 <= n) f[i] = Math.min(f[i],a[3] + a[2] + a[i + 1] + a[3] + f[i + 2]);
                    //运三个人
                    //x y z  z
                    //x y
                    //x y k  k
                    //x y
                    // a b c
                    //z k
                    if (i + 2 <= n) f[i] = Math.min(f[i] , a[3] + a[2] + a[4] + a[2] + a[i+2] + a[4] + f[i+3]);
                }
                //结果就是a[3] + f[3]
                System.out.println(a[3] + f[3]);
            }

        }
    }
}
