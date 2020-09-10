package RePractice.Summary_0824;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Code_0906_xiaohongshu2 {

/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int findMin(int[][] arr) {
        Set<Integer> set = new HashSet<>();
        long maxV = 1;
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                set.add(arr[i][j]);
                maxV = Math.max(maxV,arr[i][j]);
            }
        }
        int res = 0;
        for (int i = 1;i < maxV + 1L;i++){
            if (!set.contains(i)){
                res = i;
                break;
            }
        }
        return res;


    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int row = 0;
        int col = 0;
        row = Integer.parseInt(in.nextLine().trim());
        col = Integer.parseInt(in.nextLine().trim());

        int[][] arr = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                arr[i][j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }

        res = findMin(arr);
        System.out.println(String.valueOf(res));

    }
}
