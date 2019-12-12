package RePractice.LeetCode.Array;

public class Code_1211_695maxAreaOfIsland {
    //更加直观的方法
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            if(grid.length == 0) return 0;
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];
            int maxArea = 0;
            for(int i=0;i<row;i++) {
                for(int j=0;j<col;j++) {
                    if(grid[i][j] == 1 && !visited[i][j]) {
                        maxArea = Math.max(maxArea,dfs(grid,visited,i,j,0));
                    }
                }
            }
            return maxArea;
        }
        private int dfs(int[][] grid,boolean[][] visited,int i,int j,int area) {
            if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length - 1 || visited[i][j] || grid[i][j] != 1)
                return area;
            visited[i][j] = true;
            area++;
            area = dfs(grid,visited,i-1,j,area);
            area = dfs(grid,visited,i,j-1,area);
            area = dfs(grid,visited,i+1,j,area);
            area = dfs(grid,visited,i,j+1,area);

            return area;
        }
    }
    //更快的方法
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int maxIsland = 0 ;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row ; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1 ){
                    maxIsland = Math.max(process(grid, i , j , row , col) , maxIsland);
                }
            }
        }
        return maxIsland;
    }

    public static int process(int[][] arr  ,int i ,int j ,int row ,int col){
        if (i < 0 || i > row || j < 0 || j > col || arr[i][j] == 0 ){
            return 0;
        }
        arr[i][j] = 0;
        return  1 + process(arr , i + 1, j ,row ,col) + process(arr , i - 1 ,j ,row ,col)
                +process(arr ,i ,j + 1, row ,col) + process(arr ,i ,j - 1,row ,col);
    }

    public static void main(String[] args) {

    }
}
