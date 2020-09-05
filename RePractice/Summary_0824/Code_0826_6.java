package RePractice.Summary_0824;

public class Code_0826_6 {
    public String solution(String s,int numRows){
        if (numRows == 1){
            return s;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < numRows;i++){
            if (i == 0 || i == numRows - 1){
                for (int j = i;j < s.length();j += 2 * (numRows - 1)){
                    sb.append(s.charAt(j));
                }
            }else {
                for (int j = i,k = 2 * (numRows - 1) - i;j < s.length() || k < s.length(); j += 2 * (numRows - 1),
                        k += 2 * (numRows - 1)){
                    if (j < s.length()) sb.append(s.charAt(j));
                    if (k < s.length()) sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }
}
