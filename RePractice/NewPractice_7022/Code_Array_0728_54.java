package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;

public class Code_Array_0728_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1){
            return new ArrayList<>();
        }
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int tR = 0 , tC = 0 , dR = n - 1, dC = m - 1;
        while (tR <= dR && tC <= dC){

            if (tR == dR){
                for (int i = tC;i <= dC;i++){
                    res.add(matrix[tR][i]);
                }
            }else if (tC == dC){
                for (int i = tR;i <= dR;i++){
                    res.add(matrix[i][tC]);
                }
            }else {
                int curC = tC;
                int curR = tR;
                while (curC != dC) {
                    res.add(matrix[tR][curC]);
                    curC++;
                }
                while (curR != dR) {
                    res.add(matrix[curR][curC]);
                    curR++;
                }
                while (curC != tC) {
                    res.add(matrix[curR][curC]);
                    curC--;
                }
                while (curR != tR) {
                    res.add(matrix[curR][curC]);
                    curR--;
                }

            }
            tR++;
            tC++;
            dR--;
            dC--;
        }
        return res;
    }

    public class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> res = new ArrayList<Integer>();

            if (matrix.length == 0) {
                return res;
            }

            int rowBegin = 0;
            int rowEnd = matrix.length-1;
            int colBegin = 0;
            int colEnd = matrix[0].length - 1;

            while (rowBegin <= rowEnd && colBegin <= colEnd) {
                // Traverse Right
                for (int j = colBegin; j <= colEnd; j ++) {
                    res.add(matrix[rowBegin][j]);
                }
                rowBegin++;

                // Traverse Down
                for (int j = rowBegin; j <= rowEnd; j ++) {
                    res.add(matrix[j][colEnd]);
                }
                colEnd--;

                if (rowBegin <= rowEnd) {
                    // Traverse Left
                    for (int j = colEnd; j >= colBegin; j --) {
                        res.add(matrix[rowEnd][j]);
                    }
                }
                rowEnd--;

                if (colBegin <= colEnd) {
                    // Traver Up
                    for (int j = rowEnd; j >= rowBegin; j --) {
                        res.add(matrix[j][colBegin]);
                    }
                }
                colBegin ++;
            }

            return res;
        }
    }

}
