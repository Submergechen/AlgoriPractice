package RePractice.LeetCode_Classify.SingleStackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Code_0501_918 {
    //这个题好像有更快的方法！！
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int[] sum = new int[2 * n + 1];
        for (int i = 1;i <= 2 * n; i++){
            //或者构建一个2n的数组？
            sum[i] = sum[i - 1] + A[(i - 1) % n];

        }
        int res = Integer.MIN_VALUE;
        Deque<Integer> qmin = new LinkedList<>();
        //为啥加0？
        qmin.add(0);
        for (int j = 1; j <= 2 * n; j++){
            //minus
            //由于是前缀和，所以和那个maxWindow不一样， 是> 而不是>= ！！
            if (!qmin.isEmpty() && j - n > qmin.peekFirst()){
                qmin.pollFirst();
            }
            if (!qmin.isEmpty()){
                res = Math.max(res,sum[j] - sum[qmin.peekFirst()]);
            }
            while (!qmin.isEmpty() && sum[qmin.peekLast()] >= sum[j]){
                qmin.pollLast();
            }
            qmin.add(j);
        }
        return res;
    }
}
