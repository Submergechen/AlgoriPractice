package RePractice.LeetCode_Classify.DP;
//第四题
public class Code_0505_91 {
    //这个题意思还不是搞很懂！！尤其i 和i - 1 什么的
    public int numDecodings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1;i <= n;i++){
            //用的是第i个！ 下标从0开始的
            if (chars[i - 1] != '0'){
                f[i] += f[i-1];
            }
            if (i >=2){
                int t = (chars[i - 2] - '0') * 10 + chars[i - 1] - '0';
                if (t >= 10 && t <= 26){
                    f[i] += f[i-2];
                }
            }
        }
        return f[n];
    }





}
