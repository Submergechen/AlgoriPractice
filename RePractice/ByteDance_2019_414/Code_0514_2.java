package RePractice.ByteDance_2019_414;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Code_0514_2 {

    public static void main(String[] agrs){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int res = 0;

        Map<int[],Integer> last_time = new HashMap<>();
        Map<int[],Integer> count = new HashMap<>();
        //从1开始可以更好处理边界！ 因为有一个 i-1的情况
        for (int i = 1;i <= n;i++){
            int m;
            m = sc.nextInt();
            for (int j = 0; j < m;j++){
                int[] t = new int[2];
                t[0] = sc.nextInt();
                t[1] = sc.nextInt();
                //如果出现是上次，那么直接对次数++
                if (last_time.getOrDefault(t,0) == i - 1){
                    if (count.containsKey(t)){
                        count.put(t,count.getOrDefault(t,0) + 1);
                    }
                }else if (last_time.getOrDefault(t,0) < i - 1){
                    //否则连续次数 赋值为1
                    count.put(t,1);
                }
                last_time.put(t,i);
                res = Math.max(res,count.get(t));
            }

        }
        System.out.println(res);
    }

}
