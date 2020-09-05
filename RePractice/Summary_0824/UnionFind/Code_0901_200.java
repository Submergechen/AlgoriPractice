package RePractice.Summary_0824.UnionFind;

public class Code_0901_200 {
    int[] p;
    public int numIslands(char[][] grid) {
        int
        for (i)
    }

    public void union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if (fx != fy){
            p[fx] = p[fy];
        }
    }
    public int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}

