package RePractice.SwordOffer0316Twice;

public class Code_0410_60printProbability {
    /**
     * 这个题用dfs会超时，用dfs的时候一定要考虑函数里的状态是什么，如何去计算状态
     * 计算状态，可选的方案就是枚举最后一次掷骰子de点数
     * @param n
     * @return
     */
    //热狗法，和dp很像，划分成不重不漏de情况
    public int[] solution(int n){
        int[] res = new int[6 * (n -1)];
        int index = 0;
        for (int i = n; i <= 6 * n; i++){
            res[index++] = dfs(i,n);
        }
        return res;
    }

    public int dfs(int sum , int n){
        //边界
        if (sum < 0 ){
            return 0;
        }
        //按照什么样的顺序去枚举
        //枚举一下最后一个骰子的点数是多少  假设是i 那么dfs（sum - i , n - 1）
        //这样就可以继续考虑边界 ，边界是n-1
        //如果 n 为0的时候，sum也是0那么就是一种方案
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        int res = 0;
        //最后一次掷骰子的点数
        for (int i = 1;i <= 6 ; i++){
            res += dfs(sum - i , n - 1);
        }
        return res;
    }


    //dp的方法和这个类似，只不过每一种状态只会计算一次，保存起来
    //f[i][j] 前i次 总和为j的方案数
    public int[] solution(int n){
        int[][] f = new int[n + 1][6 * n + 1];
        f[0][0] = 1;
        //i代表次数，扔骰子的次数
        //j代表骰子数的总和是多少
        //k代表最后一次骰子数是多少
        for (int i = 1;i <= n; i++){
            for (int j = 1; j <= 6 * n ;j++){
                for (int k = 1; k <= Math.max(j,6);k++){
                    //k小于j
                    f[i][j] += f[i - 1][j - k];
                }
            }
        }
        int[] res = new int[6 * (n- 1)];
        for (int i = n ; i < 6 * n;i++){
            res[i] = f[n][i];
        }
    }
}
