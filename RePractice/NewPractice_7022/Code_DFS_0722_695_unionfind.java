package RePractice.NewPractice_7022;

public class Code_DFS_0722_695_unionfind {
    int n;
    int m;
    boolean[][] is_visited;
    int max = 0;
    int res;
    int[] p;
    int[] size;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                p[i * n + j] = i * n + j;
            }
        }
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if ()
            }
        }

    }

    public int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return  p[x];
    }

    public void merge(int fx , int fy){
        if (find(fx) != find(fy)){
            p[fx] = fy;
        }
    }
}
