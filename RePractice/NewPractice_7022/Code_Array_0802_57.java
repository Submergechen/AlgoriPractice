package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code_Array_0802_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
//        if (intervals.length <= 1){
//            return intervals;
//        }

        int i = 0;
        List<int[]> merged = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            merged.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        while (i < intervals.length && intervals[i][0] < newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        while (i < intervals.length){
            merged.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        return merged.toArray(new int[merged.size()][]);
    }

}
