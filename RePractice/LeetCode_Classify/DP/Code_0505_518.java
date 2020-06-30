package RePractice.LeetCode_Classify.DP;

public class Code_0505_518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int c : coins){
            for (int j = c; j <= amount;j++){
                f[j] += f[j-c];
            }
        }
        return f[amount];
    }
}
