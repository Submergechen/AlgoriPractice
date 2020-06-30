package RePractice.ByteDance_2019;

import java.util.Arrays;
import java.util.Scanner;

//这个题很难！！
public class Code_0414_3prize {
    static int N = 10010;
    //打乱排序以后，还需要原来的下标是多少
    class Pair{
        //first存得分
        int first;
        //second存下标s
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] agrs){
        //记一下最终小朋友分的糖果数量
        int[] b = new int[N];
        //每个小朋友原来的分数
        int[] a = new int[N];
        //n是小朋友的数量
        int n;
        Scanner sc = new Scanner(System.in);
        int exam_num;
        Pair children[] = new Pair[N];
        exam_num = sc.nextInt();
        while ((exam_num--) != 0){
            n = sc.nextInt();

            for (int i = 0; i < n;i++){
                a[i] = sc.nextInt();
                children[i].first = a[i];
                children[i].second = i;
            }
            Arrays.sort(children);
            for (int i = 0;i < n; i++){
                Pair c = children[i];
                //而且第第一个和第n个是相邻的
                //所以用取模运算更好,防止越界，当下标是0的时候，-1应该映射成n-1； 当是n-1的时候，应该映射成0
                int left = (c.second + n - 1)% n;
                int right = (c.second + 1) % n;
                //先规定左边最大值是1 ，右边最大糖果数是1；
                int lv = 1 , rv = 1;
                if (c.first > a[left]) lv = b[left] + 1;
                if (c.first > a[right]) rv = b[right] + 1;
                b[c.second] = Math.max(lv,rv);
            }
            long res = 0;
            for (int i = 0; i< n; i++){
                res += b[i];
            }
            System.out.println(res);
        }
    }
}
