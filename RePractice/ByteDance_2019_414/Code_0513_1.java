package RePractice.ByteDance_2019_414;

import java.util.LinkedList;
import java.util.Queue;

//bfs比较经典de 题目
//省略输入数据部分
public class Code_0513_1 {
    //pair 可以用int[] 数组来代替 不一定要用c++里面的pair

    //省略输入数据
    public int bfs(int[][] input , int n, int m){
        //距离！
        int[][] dist = new int[n][m];
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                dist[i][j] = -1;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (input[i][j] == 2){
                    dist[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        //上下左右
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        //bfs的过程！ 向四周扩散！
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0] ,y = temp[1], d = dist[x][y];

            for (int i = 0;i < 4;i++){
                int a = x + dx[i] , b = y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && input[a][b] == 1 && dist[a][b] == -1 ){
                    dist[a][b] = d + 1;
                    queue.add(new int[]{a,b});
                }
            }
        }
        int res = 0;
        for (int i = 0 ;i < n ;i++){
            for (int j =0 ;j < m; j++){
                if (input[i][j] == 1){
                    if (dist[i][j] == -1){
                        return -1;
                    }
                    res = Math.max(res,dist[i][j]);
                }
            }
        }
        return res;
    }
}
