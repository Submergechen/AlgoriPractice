package RePractice.SwordOffer0316Twice;


/**
 * 字符串匹配可以用动态规划来做
 * 状态表示： f[i][j] 表示s[i,.......]和 p[j, .....]相匹配
 *
 * 状态转移：
 * 1. p[j]是正常字符，那么f[i][j] = s[i] == p[j] && f[i][j] = f[i+1][j+1];
 * 2. p[j]是 . 字符，那么f[i][j] = f[i+1][j+1];
 * 3. p[j+1]是 * 字符，f[i][j] = f[i][j+2] || f[i+1][j]
 * 那么有几种情况，b* 这种， * 代表前面0个 f[i][j] = f[i][j+2]
 * 其他情况，代表n个前面的字母，所有情况都包括在 f[i][j] = f[i+1][j] 这种里面
 */
public class Code_0331_19matchString {
    int n,m;
    boolean[][] f;
    char[] str , exp;
    public boolean solution1(char[] _str ,char[] _exp , int i ,int j){
        str = _str;
        exp = _exp;
        int n = str.length;
        int m = exp.length;

        boolean[][] f = new boolean[n+1][m+1];
        for (int p = 0;p < n+1; p++){
            for (int q = 0; q < m+1;q++){
                f[p][q] = false;
            }
        }
        return dp(0,0);
    }

    public boolean dp(int x , int y){
        //如果已经计算过了
        if (f[x][y] != false){
            return f[x][y];
        }
        if (y == m){
            return f[x][y] = x == m;
        }

        boolean fist_match = x < n && (str[x] == exp[y] || exp[y] == '.');
        if (y + 1 < m && exp[y+1] == '*'){
            f[x][y] = dp(x,y+2 )||dp(x+1,y);
        }else {
            f[x][y] = fist_match && dp(x+1,y+1);
        }
        return f[x][y];
    }


    //递归
    public static boolean process(char[] str , char[] exp , int i ,int j){
        if (j == exp.length){
            return i == str.length;
        }
        //考虑j+1的情况，
        if (j + 1 == exp.length || exp[j+1] != '*'){
            return i != str.length && (str[i] == exp[j] || exp[j] =='.') &&
                    process(str,exp,i+1,j+1);
        }
        //exp j+1  '*'
        while (i != str.length && (str[i] == exp[j] || exp[j] == '.')){
            if (process(str,exp,i,j+2)){
                return true;
            }
            i++;
        }

        return process(str,exp,i,j+2);
    }


    public void solution(){

    }
}
