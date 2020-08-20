package RePractice.NewPractice_7022;

public class Code_Array_0725_28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null){
            return 0;
        }

        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();

        int res = -1;
        int cur = 0;
        for (int i = 0;i < chars1.length;i++){
            int k = i;
            while (chars1[k] == chars2[cur] && cur < chars2.length){
                k++;
                cur++;
            }
            if (cur == chars2.length) {
                return i;
            }else {
                cur = 0;
            }
        }
        return res;
    }

    public int strStr1(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();

        if (len1 < len2){
            return  -1;
        }
        if (len2 < 1){
            return 0;
        }
        int diff = len1 - len2;
        for (int i = 0; i <= diff;i++){
            if (haystack.substring(i,i + len2).equals(needle)){
                return i;
            }
        }
        return -1;
    }

}
