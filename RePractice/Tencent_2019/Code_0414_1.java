package RePractice.Tencent_2019;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 凑硬币，能用面额大的就用当前面额大的！覆盖的范围更广
 */
public class Code_0414_1 {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        //m是凑的目标金额 ，凑 1----m
        int m = sc.nextInt();
        //n是有几种面额的硬币
        int n = sc.nextInt();
        int[] a = new int[n];
        Arrays.sort(a);
        //如果没有1这个硬币 那凑不出来所有的！
        if (a[0] != 1){
            System.out.println(-1);
        }else {
            while (n > 0 && a[n-1] > m){
                n--;
            }
            //由于要凑出最大面额为m的钱，可以把面额为m当作最大那个硬币，这样写起来代码整齐很多
            //Kai + s >= a(i+1) - 1 ,那么ai+1 - 1 = m 即an = m + 1；
            a[n] = m + 1;
            int res = 0;
            //s是凑出的那个长度 1----s
            for (int i = 0 , s = 0; i < n; i++){
                //上取整公式， 加多少个a[i]可以满足条件
                int k = (a[i+1] - 1 - s + a[i] - 1) / a[i];
                s += k * a[i];
                res += k;
            }
            System.out.println(res);
        }

    }
}
