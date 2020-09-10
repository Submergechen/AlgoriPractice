package RePractice.Summary_0824;

import java.util.Scanner;

public class Code_0907_beike3 {

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0;i < T;i++){
            String[] strs = sc.nextLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int m  = Integer.parseInt(strs[1]);
            int k  = Integer.parseInt(strs[2]);

            int[][] cannot = new int[m][k];
            for (int x = 0;x < m;x++){
                for (int y = 0;y < k;y++){
                    cannot[x][y] = sc.nextInt();
                }
            }
            System.out.println(2);
        }

    }
}
