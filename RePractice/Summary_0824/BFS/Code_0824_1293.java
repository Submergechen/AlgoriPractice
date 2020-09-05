package RePractice.Summary_0824.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Code_0824_1293 {
    class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int steps = 0;
        Queue<Pair> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        Set<Pair> set = new HashSet<>();
        queue.add(new Pair(0,0));
        set.add(new Pair(0,0));
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i < size;i++){
                int x = queue.poll().first;
                int y = queue.poll().second;
                if (x == grid.length - 1 && y == grid[0].length - 1){
                    return steps;
                }
                for (int q = 0;q < 4;q++){
                    x = x + dx[q];
                    y = y + dy[q];
                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] != '1'){
                        Pair temp = new Pair(x,y);
                        if (!set.contains(temp)){
                            set.add(temp);
                            queue.add(temp);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public int shortestPath1(int[][] grid, int k) {
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        int steps = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] isVisted = new boolean[n][m][k + 1];
        queue.add(new int[]{0,0,0});
        isVisted[0][0][0] = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i < size;i++){
                int[] temp = queue.poll();
                int x = temp[0],y = temp[1],curK = temp[2];
                if (x == n - 1 && y == m - 1){
                    return steps;
                }
                for (int q = 0;q < 4;q++){
                    int nextR = x + dx[q];
                    int nextC = y + dy[q];
                    int nextk = curK;
                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m )
                        if (grid[nextR][nextC] == 1){
                            nextk++;
                        }
                        if (nextk <= k && !isVisted[nextR][nextC][nextk]){
                            isVisted[nextR][nextC][nextk] = true;
                            queue.add(new int[]{nextR,nextC,nextk});
                        }
                    }
                }
            steps++;
            }
            return -1;
        }
    }

