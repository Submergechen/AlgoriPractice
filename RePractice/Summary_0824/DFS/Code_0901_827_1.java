package RePractice.Summary_0824.DFS;

import java.util.*;

public class Code_0901_827_1 {
    int res = 0;
    int color = 1;
    Map<Integer,Integer> map = new HashMap<>();
    public int largestIsland(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1){
            return 0;
        }

        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    color++;
                    map.put(color,dfs(grid,i,j));
                    res = Math.max(res,map.get(color));
                }
            }
        }
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 0){
                    int area = 1;
                    Set<Integer> color = new HashSet<>();
                    color.add(getColor(grid,i - 1,j));
                    color.add(getColor(grid,i + 1,j));
                    color.add(getColor(grid,i,j - 1));
                    color.add(getColor(grid,i,j + 1));
                    for (int temp : color){
                        area += (map.containsKey(temp) ? map.get(temp) : 0);
                    }
                    res = Math.max(res,area);
                }
            }
        }
        return res;
    }
    public int getColor(int[][] grid, int i ,int j){
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) ? grid[i][j] : 0;
    }

    public int dfs(int[][] grid, int i ,int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return 0;

        }
        grid[i][j] = color;
        return  1 + dfs(grid,i + 1,j) + dfs(grid,i - 1,j)+ dfs(grid,i,j + 1)
                + dfs(grid,i,j - 1);
    }
}
