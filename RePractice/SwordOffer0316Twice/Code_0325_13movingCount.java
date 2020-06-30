package RePractice.SwordOffer0316Twice;

public class Code_0325_13movingCount {
    public int solution(int[][] arr , int m ,int n , int k){
        if (arr == null || arr.length < 1 || arr[0].length < 1){
            return 0;
        }

        boolean[][] visited = new boolean[m][n];
        for (int i = 0;i < m ;i++){
            for (int j = 0 ;j < n ; j++){
                visited[i][j] = false;
            }
        }
        int res = 0;
        return process(arr , visited , res,0 , 0 , m , n , k);
    }




    public int process(int[][] arr ,boolean[][] visited ,int res ,  int i ,int j ,int m ,int n ,int k){
        if (i < 0 || i > m || j > 0 || j < n  || visited[i][j] ){
            return 0;
        }
        visited[i][j] = true;

        if (!check(i ,j ,k)){
            return 0;
        }

        return 1 + process(arr,visited,res ,i,j,m,n,k) + process(arr,visited,res,i,j,m,n,k)
                + process(arr,visited,res,i,j,m,n,k)
                +process(arr,visited,res,i,j,m,n,k);
    }

    public boolean check(int i , int j ,int k){
        int sum = 0;

        while (i != 0){
            sum += i % 10;
            i = i / 10;
        }


        while (j != 0){
            sum += j % 10;
            j = j / 10;
        }
        if (sum > k ){
            return false;
        }
        return true;
    }
}
