package RePractice.LeetCode_Classify.BFS;

public class Code_0507_733 {
    //好像就是头条那个题目
    //dfs
    //这里为啥不用回溯？ 因为不是找最短路径什么的！！ 不是求最小值，不是搜索路径 所以不用回溯， 染色的这种直接全部染色就可以了！！

    //To put it another way: we are using the changing colour to keep track of which pixels we've already visited.
    // If the colour doesn't change, we forget where we've been and visit the same pixels over and over again.
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length < 1 || image[0].length < 1){
            return image;
        }
        int oldColor = image[sr][sc];
        //if (oldColor != newColor) 如果不加这句！！ 会stackoverflow 栈溢出！ 因为颜色不变化的话，函数会一直循环下去！！
        if (oldColor != newColor) dfs(image,sr ,sc ,newColor,oldColor);

        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor,int oldColor){
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == oldColor){
            image[sr][sc] = newColor;
            dfs(image,sr - 1 ,sc ,newColor,oldColor);
            dfs(image,sr + 1 ,sc ,newColor,oldColor);
            dfs(image,sr  ,sc - 1 ,newColor,oldColor);
            dfs(image,sr ,sc + 1 ,newColor,oldColor);
        }
    }
}
