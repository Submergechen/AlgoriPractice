package RePractice.NewPractice_7022;

import java.util.TreeMap;

public class Code_String_0723_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }

        StringBuffer sb = new StringBuffer();
        String temp = strs[0];

        for (int i = 0; i < temp.length();i++){
            boolean euqal = true;
            for (String str : strs){
                //有可能后面字符长度不够
                if (str.length() <= i || temp.charAt(i) != str.charAt(i)){
                    euqal = false;
                    break;
                }
            }
            if (euqal == false){
                break;
            }
            sb.append(temp.charAt(i));
        }
        return sb.toString();

    }
}
