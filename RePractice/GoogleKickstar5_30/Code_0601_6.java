package RePractice.GoogleKickstar5_30;


import class_08.FaceBook;

import java.util.Scanner;

public class Code_0601_6 {
    static int N = 10010;
    static int n,m;
    static int[] p = new int[N];
    static int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public static void main(String[] agrs){
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int C = 1; C <= T; C++){
            //n代表樱桃数量
            n = sc.nextInt();
            //m代表黑色糖链数量
            m = sc.nextInt();
            for (int i = 1;i <= n;i++){
                p[i] = i;
            }
            int k = 0;
            while (m-- != 0){
                int a , b;
                a = sc.nextInt();
                b = sc.nextInt();
                if (find(a) != find(b)){
                    p[find(a)] = find(b);
                    k++;
                }
            }
            System.out.println("Case #" + C + k * 1 + (n - 1 - k) * 2);
        }

    }
}
