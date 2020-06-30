package RePractice.ByteDance_2019;

import java.util.Scanner;

/**
 * 经典二分s
 */
public class Code_0414_4cut {
    static int N = 10010;
    static int n , m ;
    static int[] a = new int[N];
    public static void main(String[] agrs){


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i =0;i < n;i++){
            a[i] = sc.nextInt();
        }
        double l = 0 , r = 1e9;
        //浮点数的二分
        while (r - l > 1e-4){
            double mid = (r + l) /2;
            if (check(mid)){
                l = mid + 1;
            }else {
                r = mid;
            }

        }
        System.out.println(l);
    }
    public static boolean check(double mid){
        int s = 0;
        for (int i = 0 ; i < n;i++){
            s += a[i] /mid;
            if (s >= m) {
                return true;
            }
        }
        return false;
    }
}
