package RePractice.LeetCode_Classify.BoYiLun;

public class Code_0616_464 {
    //用了很多优化 剪枝  2的m
    int[] q;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (1 + maxChoosableInteger) /2;
        //这里写反了！！
        if (desiredTotal > sum){
            return false;
        }
        if (desiredTotal <= 0){
            return true;
        }
        //记忆化， 状态
         q = new int[1 << maxChoosableInteger];
        return dfs(maxChoosableInteger,desiredTotal,0);
    }
    //0 unknow  1 can win  -1 can't win
    public boolean dfs(int m , int t, int state){
        if (t <= 0){
            return false;
        }
        if (q[state] != 0){
            return q[state] == 1;
        }
        for (int i = 0;i < m;i++){
            if ((state & (1 << i)) != 0){
                continue;
            }
            if (!dfs(m,t - (i + 1),state | (1 << i))){
                q[state] = 1;
                return true;
            }
        }
        q[state] = -1;
        return false;
    }
}
