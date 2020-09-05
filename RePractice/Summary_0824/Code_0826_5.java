package RePractice.Summary_0824;

public class Code_0826_5 {
    public String solution(String s){
        String res = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length();i++){
            for (int j = i,k = i;j >= 0 && k < s.length() && chars[j] == chars[k];j--,k++){
                if (res.length() < k - j + 1){
                    res = s.substring(j, k + 1);
                }
            }
            for (int j = i,k = i + 1;j >= 0 && k < s.length() && chars[j] == chars[k];j--,k++){
                if (res.length() < k - j + 1){
                    res = s.substring(j, k + 1);
                }
            }
        }
        return res;
    }
}
