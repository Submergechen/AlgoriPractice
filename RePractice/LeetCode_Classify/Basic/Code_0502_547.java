package RePractice.LeetCode_Classify.Basic;
//第六题
public class Code_0502_547 {
    //图的方法没太搞懂！！ 无向图
    //下面有一种简单de理解方法
    int[] p;
    public int findCircleNum(int[][] M) {

        int n = M.length;
        p = new int[n];
        for (int i = 0;i < n; i++){
            p[i] = i;
        }
        int res = n;
        for (int i = 0;i < n;i++){
            for (int j = 0; j < i; j++){
                if (M[i][j] == 0){
                    continue;
                }
                if (find(i) != find(j)){
                    p[find(i)]  = find(j);
                    res--;
                }
            }

        }
        return res;

    }


    public int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }

    //也可以这样做s
    for (int i = 0;i < n;i++){
        for (int j = 0; j < i; j++){
            if (M[i][j] == 1{
                    p[find(i)]  = find(j);
            }

        }

    }
    //统计下多少个圈子， 自己的老大是自己！！
    int res;
    for(int i = 0; i < n; i++){
        if (find(x) == x){
            res++;
        }
    }
    return res;
}
