package RePractice.GoogleKickstar5_30;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.Scanner;
//数独检查！ 和之前那个数独很像！
public class Code_0530_1 {
    //第一题 数独检查
    static int n ,m;
    static int N = 40;
    static int[][] a = new int[N][N];
    static boolean[] st = new boolean[N];
    public static void main(String[] agrs){
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int C  = 1;C <= T;C++){
            n = sc.nextInt();
            m = n * n;
            for (int i = 0;i < m;i++){
                for (int j = 0;j < m;j++){
                    a[i][j] = sc.nextInt();
                }
            }
            if (check_row() && check_col() && check_cell()){
                System.out.println("Case #" + C + ": Yes" );
            }else {
                System.out.println("Case #" + C + ": No" );
            }
        }
    }

    public static boolean  check_row(){

        //每一行！
        for (int i = 0;i < m;i++){
            for (int k = 0;k < N; i++){
                st[k] =false;
            }
            for (int j = 0;j < m;j++){
                int t = a[i][j];
                if (t < 1|| t > m){
                    return false;
                }
                if (st[t]){
                    return false;
                }
                st[t] = true;
            }
        }
        return true;
    }
    public static boolean  check_col(){

        //每一列！
        for (int i = 0;i < m;i++){
            for (int k = 0;k < N; i++){
                st[k] =false;
            }
            for (int j = 0;j < m;j++){
                int t = a[j][i];
                if (t < 1|| t > m){
                    return false;
                }
                if (st[t]){
                    return false;
                }
                st[t] = true;
            }
        }
        return true;
    }

    public static boolean check_cell(){
        for (int x = 0;x < m;x += n){
            for (int y = 0;y < m;y += n){
                //置为false
                 for (int k = 0;k < N;k++){
                     st[k] = false;
                 }
                 for (int dx = 0;dx < n;dx++){
                     for (int dy = 0;dy < n;dy++){
                         int t = a[x + dx][y + dy];
                         if (t < 1|| t > m){
                             return false;
                         }
                         if (st[t]){
                             return false;
                         }
                         st[t] = true;
                     }
                 }
            }
        }
        return true;
    }
}
