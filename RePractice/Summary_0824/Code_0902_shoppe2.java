package RePractice.Summary_0824;

public class Code_0902_shoppe2 {
    // abcabca
    public int getMinLen (String str) {
        char[] chars = str.toCharArray();
        String strTemp = str.substring(1);

        char temp = chars[0];
        int index = strTemp.indexOf(temp);
        int len = index + 1;
        int res = str.length() % len;
        return len - res;
    }
    public int getMinLen1 (String str) {
        char[] chars = str.toCharArray();
        String strTemp = str.substring(1);
        //第一个字符
        char temp = chars[0];
        int res = Integer.MAX_VALUE;
        for (int i = 0;i < strTemp.length();i++){
            if (strTemp.charAt(i) == temp){
                String strHelper = str.substring(0,i + 1);
                int len = strHelper.length();
                int cur = str.length() % len;
                res = Math.min(res,len - cur);
            }
        }
        return res;
    }
}
