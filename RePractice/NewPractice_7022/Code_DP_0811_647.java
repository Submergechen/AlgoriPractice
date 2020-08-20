package RePractice.NewPractice_7022;

public class Code_DP_0811_647 {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int len = chars.length;
        for(int i = 0; i < len;i++){
            for(int j = 0;
                i - j >= 0 && i + j < len && chars[i - j] == chars[i + j];
                j++){
                res ++;
            }
            //j以距离作为参数！
            for(int j = 1;
                i - j + 1 >= 0 && i + j < len && chars[i - j + 1] == chars[i + j];
                j++){
                res ++;
            }

        }
        return res;
    }
    //高于99.5% !
    public int countSubstrings2(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for(int i = 0;i < chars.length;i++){
            for(int j = i,k = i;j >= 0 && k < chars.length
                    && chars[j] == chars[k];j--,k++){
                res++;
            }
            for(int j = i,k = i + 1;j >= 0 && k < chars.length
                    && chars[j] == chars[k];j--,k++){
                res++;
            }
        }
        return res;
    }
    //dp
    public int countSubstrings1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int i = 0; i < n;i++){
            dp[i][i] = true;
            res++;
        }
        for (int i = 0; i < n - 1;i++){
            if (s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                res++;
            }
        }

        for (int len = 3;len <= n;len++){
            for (int i = 0; i <= n - len;i++){
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]){
                        res++;
                    }
                }
            }
        }
        return res;
    }



}
