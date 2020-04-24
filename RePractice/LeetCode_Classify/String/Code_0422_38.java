package RePractice.LeetCode_Classify.String;

public class Code_0422_38 {
    public String countAndSay(int n) {
        //String.valueOf(k - j) 是把 k-j当成字符串了！！
        String s = "1";
        for (int i = 0 ; i < n-1; i++){
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++){
                int k = j;
                while (k < chars.length && chars[k] == chars[j]){
                    k++;
                }

                sb.append(String.valueOf(k-j));
                sb.append(String.valueOf(chars[j]));
                j = k - 1;
            }
            s = sb.toString();
        }
        return s;
    }
}
    //改写成函数！！ 效率更高更高！！
    public String countAndSay(int n) {
        //String.valueOf(k - j) 是把 k-j当成字符串了！！
        String s = "1";
        for (int i = 0 ; i < n-1; i++){
            int len = s.length();;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length();){
                int k = j;
                while (k < len && s.charAt(k) == s.charAt(j)){
                    k++;
                }

                sb.append(k-j);
                sb.append(s.charAt(j));
                j = k;
            }
            s = sb.toString();
        }
        return s;
    }

    //最快的做法！！！！
    public String countAndSay(int n) {
        int i = 0;
        String s = "1";
        while (i < n - 1)
        {
            s = _countAndSay(s);
            i++;
        }
        return s;
    }

    private String _countAndSay(String s)
    {
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < n)
        {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i))
            {
                j++;
            }
            sb.append(j - i);
            sb.append(s.charAt(i));

            i = j;
        }
        return sb.toString();
    }
    public String countAndSay1(int n) {
        String s = "1";
        for(int i = 1; i < n ; ++i){
            s = nextNumber(s);
        }
        return s;
    }

    public static String nextNumber(String s){
        int index = 0;
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while(index < charArray.length){
            int count = 1;
            int j = index + 1;
            while( j < charArray.length && charArray[index] == charArray[j] ){
                ++j;
                ++count;
            }
            sb.append(String.valueOf(count));
            sb.append(String.valueOf(charArray[index]));
            index = j;
        }
        return sb.toString();

    }
