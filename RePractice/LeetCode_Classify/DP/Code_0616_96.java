package RePractice.LeetCode_Classify.DP;

public class Code_0616_96 {
    public int numTrees(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] sum = new int[n + 1];
        sum[0] = 1;
        sum[1] = 1;
        //枚举长度 枚举个数
        for (int i = 2;i <= n;i++){
            for (int j = 0;j < i;j++){
                sum[i] += sum[j] * sum[i - j - 1];
            }
        }
        return sum[n];
    }
}
