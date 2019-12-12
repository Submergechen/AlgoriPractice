package RePractice.LeetCode.Array;

public class Code_1209_1266MinimunTime {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points == null || points.length < 2){
            return 0;
        }
        int res = 0;
        for (int i = 0 ;i < points.length - 1; i++ ){
            int xlength = Math.abs(points[i][0] - points[i+1][0]);
            int ylength = Math.abs(points[i][1] - points[i+1][1]);
            res += Math.max(xlength,ylength);
        }
        return res;
    }
}
