package RePractice.SwordOffer;

public class Code_1216_13movingCount {
    public static int robotMoving(int[][] arr ,int m , int n , int k){
        if (arr == null || m < 0 || n < 0 || k < 0){
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n ; j++){
                visited[i][j] = false;
            }
        }
        res = process(arr ,0 ,0 ,m ,n , visited , res , k);
        return res;

    }

    public static int process(int[][] arr ,int i ,int j ,int m ,int n ,boolean[][] visited ,int res ,int k){
        if (i < 0 || i >= m || j < 0 || j >= n ||visited[i][j]){
            return 0;
        }
        visited[i][j] = true;

        if (!isValid(i,j,k)){
            return 0;
        }
        res += process(arr , i+1,j,m,n,visited,res,k);
        res += process(arr , i-1,j,m,n,visited,res,k);
        res += process(arr , i,j+1,m,n,visited,res,k);
        res += process(arr , i,j-1,m,n,visited,res,k);
        return res;
    }

    public static boolean isValid(int i ,int j ,int k){
        int sum = 0;
        while (i != 0){
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0){
            sum += j % 10;
            j = j / 10;
        }
        if (sum > k){
            return false;
        }
        return true;
    }
}
