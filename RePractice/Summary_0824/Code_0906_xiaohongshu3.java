package RePractice.Summary_0824;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Code_0906_xiaohongshu3 {

/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static void dfs(int distance,int target,int temp) {
        if (distance >= target){
            res = Math.min(res,temp);
            return ;
        }
        if (set.contains(distance)){
            temp++;

        }
        dfs(distance + minSpeed,target,temp);
        dfs(distance + maxSpeed,target,temp);

    }
/******************************结束写代码******************************/

     static   int minSpeed = 0;
      static   int maxSpeed = 0;
      static Set<Integer> set = new HashSet<>();
      static int res = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);


        int n = 0;

        n = Integer.parseInt(in.nextLine().trim());


        int dangerCount = 0;
        minSpeed  = in.nextInt();
        maxSpeed  = in.nextInt();
        dangerCount  = in.nextInt();

        //in.nextLine();
        String[] str = in.nextLine().split(" ");
        int[] dangerArea = new int[dangerCount];
        for (int i = 0;i < dangerCount;i++){
            dangerArea[i] = Integer.parseInt(str[i]);
            set.add(dangerArea[i]);
        }
        if(in.hasNextLine()) {
          in.nextLine();
        }
        dfs(0,n,0);

        System.out.println(String.valueOf(res));

    }
}
