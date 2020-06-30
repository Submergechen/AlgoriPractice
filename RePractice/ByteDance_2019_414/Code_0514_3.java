package RePractice.ByteDance_2019_414;

import java.util.Scanner;

public class Code_0514_3 {
    static int n;
    static int[] h;
    public static void main(String[] agrs){


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h= new int[n + 1];
        for (int i = 1; i <= n;i++){
            h[i] = sc.nextInt();
        }

        int l = 0 , r = 100000;
        while (l < r){
            int mid = l + r >> 1;
            if (check(mid)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    public static boolean check(int e){
        for (int i = 1;i < n;i++){
            e = 2 * e - h[i];
            if (e > 10000){
                return true;
            }
            if (e < 0){
                return false;
            }
        }
        return true;
    }
}
