package RePractice.Summary_0824;

import java.util.ArrayList;
import java.util.List;

public class Code_0904_bilibli2_1 {

    public int[] SpiralMatrix (int[][] matrix) {
        int M = matrix.length;
        if (M == 0){
            return new int[]{};
        }
        int N = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int i , j;
        int p = M, q = N;
        int m = 0;
        while (p > 0 && q > 0){
            i = m;
            j = m;
            while (j <= N -m - 1) res.add(matrix[i][j++]);
            i = i + 1;j = N - m - 1;
            while (j <= M -m - 1) res.add(matrix[i++][j]);
            i = M - m - 1;j = j - 1;
            while (i > m && j >= m) res.add(matrix[i][j--]);
            i = i - 1;j = m;
            while (i > m && j < N - m - 1) res.add(matrix[i--][j]);
            m++;
            p -= 2;
            q -= 2;
        }
        int len = res.size();
        int[] ans = new int[len];
        for (int k = 0;k < len;k++){
            ans[k] = res.get(k);
        }
        return ans;
    }
}
