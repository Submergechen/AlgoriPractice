package RePractice.Meituan_2019;

import java.util.Scanner;

//蛇形矩阵
public class Code_0514_1 {
    //第一题
    static int N = 110;
    static int[][] res  = new int[N][N];
    static boolean[][] st  = new boolean[N][N];
    static int n,m;

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //定义四个方向
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int x = 0, y = 0 , d = 0;
        //填数
        for (int i = 1;i <= n*m;i++){
            int nx = x + dx[d] , ny = y + dy[d];
            //碰墙的情况
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || st[nx][ny]){
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            res[nx][ny] = i;
            st[nx][ny] = true;
            x = nx;
            y = ny;

        }
        for (int i = 0; i < n;i++){
            for (int j = 0;j < m;j++ ){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
