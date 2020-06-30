package RePractice.LeetCode_Classify.Binary;
/**
 * 第四题
 */
public class Code_0416_4_74 {
    public boolean solution(int[][] matrix, int target){
        //用一个一维数组来模拟二维数组！！
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0 , r = rows * cols - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (matrix[mid / cols][mid % cols] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if (matrix[r / cols][r % cols] != target){
            return false;
        }
        return true;
    }
}
