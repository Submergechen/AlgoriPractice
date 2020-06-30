package RePractice.LeetCode_Classify.Binary;

public class Code_0610_1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int r = Math.min(m,n);
        int l = 0;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (check(mat,mid,threshold)) {
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean check(int[][] mat, int mid ,int threshold){
        for (int i = 0;i <= mat.length - mid;i++){
            for (int j = 0;j <= mat[0].length - mid;j++){
                int sum = 0;
                for (int dx = 0;dx < mid;dx++){
                    for (int dy = 0;dy < mid;dy++){
                        sum += mat[i + dx][j + dy];
                    }
                }
                if (sum <= threshold){
                    return true;
                }
            }
        }
        return false;
    }
}
