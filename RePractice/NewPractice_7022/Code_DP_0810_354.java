package RePractice.NewPractice_7022;

import java.util.Arrays;
import java.util.Comparator;

public class Code_DP_0810_354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        for (int i = 0;i < envelopes.length;i++){
            int temp = 1;
            for (int j = 0;j < i;j++){
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    temp = Math.max(temp,dp[j] + 1);
                }
            }
            dp[i] = temp;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0;i < envelopes.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
