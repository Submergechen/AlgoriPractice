package RePractice.Summary_0824.Binary;

public class Code_0827_74 {
    public boolean search(int[][] matrix,int target){
        if (matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0,r = m * n - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (matrix[mid / n][mid % n] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if (matrix[l / n][l % n] != target){
            return false;
        }
        return true;
    }
}
