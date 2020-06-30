package RePractice.Meituan_2019;

import java.util.Scanner;
import java.util.Stack;

public class Code_0521_5 {
    public static void main(String[] agrs){
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T-- != 0){
            int n;
            n = sc.nextInt();
            //(n+1)x = 4n * y
            //求n+1和4n的最小公倍数， 然而最小公倍数乘以最大公约数 等于 n+1 和4n的成积
            //  4n /gcd(4n*(n+1))
            int d = gcd(4*n,n+1);
            System.out.println(4 * n / d + 1);
        }
    }
    public static int gcd(int a,int b){
        return b != 0 ? gcd(b,a % b):a;
    }
}
