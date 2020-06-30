package RePractice.LeetCode_Classify.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Code_0507_279 {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n + 1];
        for (int i = 0;i <= n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        queue.add(0);
        dist[0] = 0;
        while (!queue.isEmpty()){
            int t = queue.peek();
            queue.poll();
            if (t == n){
                return dist[t];
            }
            for (int i = 1; i * i + t <= n;i++){
                int j = i * i + t;
                if (dist[j] > dist[t] + 1){
                    dist[j] = dist[t] + 1;
                    queue.add(j);
                }
            }
        }
        return 0;
    }
}
