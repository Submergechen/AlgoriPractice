package RePractice.LeetCode_Classify.DP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Code_0616_646 {
    public int findLongestChain(int[][] pairs) {
        //先排序！！ 这种方式 是先排序一维数组de第一个，如果相等 就按第二个排！
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int len = pairs.length;

        int[] dp = new int[len];

        for (int i = 0;i < len;i++){
            dp[i] = 1;
            for (int j = 0; j < i;j++){
                if (pairs[j][1] < pairs[i][1]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0;i < len;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

//这种方法更妙！！ 对二维数组第二个数进行排序！
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.parallelSort(pairs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            int lastEnd = Integer.MIN_VALUE;
            int count = 0;
            for(int[] pair : pairs) {
                if(lastEnd<pair[0]) {
                    lastEnd = pair[1];
                    count++;
                }
            }
            return count;
        }
    }
}
