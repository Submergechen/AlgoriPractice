package RePractice.LeetCode.Array;

public class Code_1211_isLandNum {
    public static int getIslandNum(int[][] arr){
        if (arr == null || arr.length == 0 || arr[0].length == 0){
            return 0;
        }
        int row = arr.length;
        int col = arr[0].length;
        int res = 0;
        for (int i = 0; i < row ; i++){
            for (int j = 0; j < col ; j++){
                if (arr[i][j] == 1 ){
                    res++;
                    process(arr , i , j , row , col);
                }
            }
        }

        return res;
    }

    public static void process(int[][] arr , int i ,int j , int row ,int col){
        if (i < 0 || i > row || j < 0 || j > col || arr[i][j] != 1  ){
            return;
        }
        arr[i][j] = 2 ;
        process(arr ,i + 1 , j ,row ,col);
        process(arr , i -1 , j , row ,col);
        process(arr , i , j + 1 ,row ,col);
        process(arr ,i ,j - 1, row ,col);
    }
}
