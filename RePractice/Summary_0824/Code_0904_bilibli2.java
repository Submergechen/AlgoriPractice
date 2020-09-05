package RePractice.Summary_0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_0904_bilibli2 {

    public int[] SpiralMatrix (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = -1;
        for (int i =0;i < m / 2;i++){
            while (col + 1 < n && matrix[row][col + 1] != Integer.MIN_VALUE){
                col++;
                res.add(matrix[row][col]);
                matrix[row][col] = Integer.MIN_VALUE;
            }
            while (row + 1 < m && matrix[row + 1][col ] != Integer.MIN_VALUE){
                row++;
                res.add(matrix[row][col]);
                matrix[row][col] = Integer.MIN_VALUE;
            }
            while (col - 1 >= 0 && matrix[row][col - 1] != Integer.MIN_VALUE){
                col--;
                res.add(matrix[row][col]);
                matrix[row][col] = Integer.MIN_VALUE;
            }
            while (row - 1 >= 0 && matrix[row - 1][col] != Integer.MIN_VALUE){
                row--;
                res.add(matrix[row][col]);
                matrix[row][col] = Integer.MIN_VALUE;
            }
        }

        int len = res.size();
        int[] ans = new int[len];
        for (int i = 0;i < len;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public  void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                res.add(m[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                res.add(m[i][tC]);
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                res.add(m[tR][curC]);
                curC++;
            }
            while (curR != dR) {
                res.add(m[tR][curC]);
                curR++;
            }
            while (curC != tC) {
                res.add(m[dR][curC]);
                curC--;
            }
            while (curR != tR) {

                res.add(m[curR][tC]);
                curR--;
            }
        }
    }
    }
    public void rorotateEdge
    int tR = 0;
    int tC = 0;
    int dR = matrix.length - 1;
    int dC = matrix[0].length - 1;
		while (tR < dR) {

    }
}

    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
}
