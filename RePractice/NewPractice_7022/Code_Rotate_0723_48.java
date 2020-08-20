package RePractice.NewPractice_7022;

public class Code_Rotate_0723_48 {
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0;i < n;i++){
            for (int j = 0; j < i;j++){
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        for (int i = 0;i < n;i++){
            for (int j = 0; j < n / 2;j++){
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

























    public void rotate(int[][] matrix) {
        int n = matrix.length;
//        int li = 0, lj = 0;
//        int ri = n - 1 , rj = n - 1;
//        while ()
        int li = 0 , lj = 0;
        int ri = n - 1 , rj = n - 1;
        while (li < ri){
            for (int j = 0; j < rj;j ++){
                int temp = matrix[li][j];
                matrix[li][j] = matrix[rj - j][lj];
                matrix[rj - j][lj] = matrix[ri][rj - j];
                matrix[ri][rj - j] = matrix[j][rj];
                matrix[j][rj] = temp;
            }
            li++;
            lj++;
            ri--;
            rj--;
        }


    }
}
