package RePractice.ByteDance_2019;

import java.util.Scanner;

//acwing 67
//找零，一般是和贪心有关de
public class Code_0413_1zhaoling {
    //比较好的解法
    public int solution(int N){
        int n = 1024 - N;
        int res = 0;
        int[] coins = new int[]{64,16,4,1};
        for (int i = 0 ;i < 4; i++){
            res += n / coins[i];
            n %= coins[i];
        }
        return res;
    }
    public static void main(String[] agrs) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int res = 0;
        int k = 1024 - N;
        while (k / 64 != 0) {
            k -= 64;
            res++;
        }
        while (k / 16 != 0) {
            k -= 16;
            res++;
        }
        while (k / 4 != 0) {
            k -= 4;
            res++;
        }
        while (k > 0) {
            k -= 1;
            res++;
        }
        System.out.println(res);
    }

}