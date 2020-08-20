package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code_Array_0802_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();

        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length;i++){
            if (intervals[i][0] > temp[1] ){
                res.add(temp);
                temp = intervals[i];
            }else {
                temp[1] = Math.max(temp[1],intervals[i][1]);
            }
            if (i == intervals.length - 1){
                res.add(temp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
