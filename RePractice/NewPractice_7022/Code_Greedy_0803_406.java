package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code_Greedy_0803_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int[] peo : people){
            res.add(peo[1],peo);
        }
        return res.toArray(new int[res.size()][]);
    }
}
