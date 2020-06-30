package RePractice.SwordOffer0316Twice;

import java.util.ArrayList;
import java.util.List;

public class Code_0407_46getTranslationCount {
    /**
     * 动态规划，状态表示，状态计算，边界
     * f[i] 表示前i个字母有多少种方式
     * 第一种 f[i] = f[i - 1] 表示第i个字母 只翻译成一个
     * 第二种 f[i] = f[i - 2] 但是必须在 10- 25之间
     * 边界是 f[0] = 1
     */
    //正确答案
    //acwing上的代码，string超出范围了， -1 都有了！
    public int getTranslationCount(String s) {
        if (s == null){
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        //动态规划数组是从0开始的 所以数组应该是len+1
        int[] f = new int[n + 1];
        //不知道怎么表示了， 是用字符串还是用数字，把dp写一下把
        f[0] = 1;
        f[1] = 1;
        for (int i = 2 ; i <= n ; i++){
            f[i] = f[i - 1];
//            if ( (n.indexOf(i-1) * 10 + n.indexOf(i)) >= 10 &&
//                    (n.indexOf(i-1) * 10 + n.indexOf(i)) <= 25){
//                f[i] += f[i -2];
//            }
            //为什么是n- 2 因为i是从1开始走的 但是其实还要计算f[0]的部分，也就是f[-1] f[0]
            //而且n.indexOf(i -2 )  是字符，也是int 但是数很大 不是十进制的数，所以要减去'0'
            int t = (chars[i-2] - '0') * 10 + chars[i-1] - '0';
            if (t >= 10 && t <= 25){
                f[i] += f[i -2];
            }


        }
        return f[n];
    }
    //错误
    public int solution(int n){
        if (n == 0){
            return 0;
        }
        List<Integer> number = new ArrayList<>();
        while (n != 0){
            number.add(n % 10);
            n /= 10;
        }
        int[] f = new int[number.size() + 1];
        //不知道怎么表示了， 是用字符串还是用数字，把dp写一下把
        f[0] = 1;
        for (int i = 1 ; i < f.length ; i--){
            f[i] = f[i - 1];
            if (number[i] * 10 + number[i + 1] < 25 && number[i] * 10 + number[i + 1] > 10 ){
                f[i] += f[i -2];
            }

        }
        return f[n];
    }
    //不知道哪里不对！！
    public int solution2(String s){
        if (s == null){
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        //动态规划数组是从0开始的 所以数组应该是len+1
        int[] f = new int[n + 1];
        //不知道怎么表示了， 是用字符串还是用数字，把dp写一下把
        f[0] = 1;
        for (int i = 1 ; i <= n ; i++){
            f[i] = f[i - 1];
//            if ( (n.indexOf(i-1) * 10 + n.indexOf(i)) >= 10 &&
//                    (n.indexOf(i-1) * 10 + n.indexOf(i)) <= 25){
//                f[i] += f[i -2];
//            }
            //为什么是n- 2 因为i是从1开始走的 但是其实还要计算f[0]的部分，也就是f[-1] f[0]
            //而且n.indexOf(i -2 )  是字符，也是int 但是数很大 不是十进制的数，所以要减去'0'
            int t = (chars[i-2] - '0') * 10 + chars[i-1] - '0';
            if (t >= 10 && t <= 25){
                f[i] += f[i -2];
            }


        }
        return f[n];
    }
}
//int版本的
class Solution {
    public int translateNum(int num) {
        //input check
        if(num<0)
            return 0;
        char[] chs = String.valueOf(num).toCharArray();
        int n = chs.length;
        /*
        dp[i]表示以chs[i]结尾的不同的翻译数量
        dp[i]表示考虑前i个数时的不同的翻译数量
        f(i) = f(i-1) + flag*f(i-2)
        如果chs[i-1]chs[i]构成的十进制数在[10,25]范围上, 那么flag==1, 否则flag==0
        最开始分析的时候卡在了chs[i-1]chs[i]组合时仍想着和dp[i-1]有什么联系, 其实此时应该考虑和dp[i-2]有什么关系, 这样就明了了
        */
        int[] dp = new int[n+1];
        dp[0]=1; //写动态规划主体循环时才知道dp[0]要初始化为1, 比如案例num=12, 过一遍循环就知道了
        dp[1]=1;
        for(int i=2; i<=n; i++){
            //单独翻译chs[i-1]
            dp[i] = dp[i-1];
            //同时翻译chs[i-2] chs[i-1]
            // if(i-2>=0){
            int tmp = Integer.parseInt(new StringBuilder().append(chs[i-2]).append(chs[i-1]).toString());
            if(tmp>=10 && tmp<=25)
                dp[i] = dp[i] + dp[i-2];
            // }
        }
        return dp[n];
    }
}

