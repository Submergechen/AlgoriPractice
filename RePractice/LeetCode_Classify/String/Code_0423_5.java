package RePractice.LeetCode_Classify.String;

public class Code_0423_5 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length();i++){
        //j向左，k向右！！
            for (int k = i ,j = i;j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k);j--,k++){
                if (res.length() < k - j + 1){
                    res = s.substring(j,k+1);
                }
            }
            for (int k = i + 1 ,j = i;j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k);j--,k++){
                if (res.length() < k - j + 1){
                    res = s.substring(j,k+1);
                }
            }
        }
        return res;
    }
}
