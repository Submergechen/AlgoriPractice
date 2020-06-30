package RePractice.LeetCode_Classify.Basic;

public class Code_0502_684 {
    int[] p;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n + 1];
        //因为点是从1开始的？
        for (int i = 0;i <= n; i++){
            p[i] = i;
        }
        for (int[] x : edges){
            int a = x[0];
            int b = x[1];
            if (find(a) != find(b)){
                p[find(a)] = find(b);
            }else {
                return new int[]{a,b};
            }

        }
        return new int[]{-1,-1};
    }

    public int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
