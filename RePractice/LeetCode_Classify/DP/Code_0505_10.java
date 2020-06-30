package RePractice.LeetCode_Classify.DP;

//第十题
public class Code_0505_10 {
    public boolean isMatch(String s, String p) {
        int n = s.length() , m = p.length();
        s = ' ' + s;
        p = ' ' + p;
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();
        boolean[][] f = new boolean[n+1][m+1];
        for (int i = 0;i <= n;i++){
            for (int j = 0;j <= m;j++){
                if (i == 0 && j == 0){
                    f[i][j] = true;
                }else {
                    //绑定？！连续出现*
                    if (j + 1 <= m && charsP[j + 1] == '*'){
                        continue;
                    }
                    if (charsP[j] != '*'){
                        if (charsP[j] == '.' || charsP[j] == charsS[i]){
                            if (i > 0 && j >0){
                                f[i][j] = f[i - 1][j - 1];
                            }
                        }
                    }else {
                        if (j >= 2) f[i][j] = f[i][j - 2];
                        if (i > 0 && j > 0){
                            if (charsP[j - 1] =='.' || charsP[j - 1] == charsS[i]){
                                if (f[i-1][j]){
                                    f[i][j] = true;
                                }
                            }
                        }
                    }
                }

            }
        }
        return f[n][m];
    }

}
