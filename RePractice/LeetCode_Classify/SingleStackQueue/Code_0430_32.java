package RePractice.LeetCode_Classify.SingleStackQueue;

import java.util.Arrays;
import java.util.Collections;

public class Code_0430_32 {
    //合法括号 一般都是前缀和>= 0 并且 在==0的时候是合法括号

    //1 前缀和 < 0 停止 start = i + 1 , cnt = 0
    //2 前缀和 > 0 继续
    //3 前缀和 ==0 统计结果
    public int longestValidParentheses(String s) {
        int res = work(s);
        char[] chars = s.toCharArray();
        //翻转！
        int i = 0,j = chars.length - 1;
        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
//        for (char x : chars){
//            // '（'和 '）'在ascii码里面 值差1 所以最后一位是0 和1 可以这样去转换！
//            x = (char) (x ^ 1);
//        }
        //这两个地方出问题了！

        for (int k = 0 ; k < chars.length ; k++){
            chars[k] = (char)(chars[k] ^ 1);
        }
        s = String.valueOf(chars);
        return Math.max(res,work(s));
    }
    //合法括号 一般都是前缀和>= 0 并且 在==0的时候是合法括号

    //1 前缀和 < 0 停止
    //2 前缀和 > 0 继续
    //3 前缀和 ==0 统计结果
    public int work(String s){
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0, start = 0, cnt = 0 ; i < chars.length ; i++){
            if (chars[i] == '('){
                cnt++;
            }else {
                cnt--;
                if (cnt < 0){
                    start = i + 1;
                    cnt = 0;
                }else if (cnt == 0){
                    res = Math.max(res , i - start + 1);
                }

            }
        }
        return res;
    }
}
