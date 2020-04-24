package RePractice.LeetCode_Classify.String;

public class Code_0423_151 {
    //这样写！！ 仅仅是跳过空格去翻转，但是没有删除里面的空格！！！！
    // 具体看acwing那个视频怎么去空格！！
    //没写好！！
    public String reverseWords1(String s) {
        if (s == null){
            return null;
        }
        s = reverse(s,0,s.length()-1);
        //翻转每一个单词
        int n = s.length();

        for (int i = 0; i < n;i++){
            //去掉前面的空格！
            while (i < n && s.charAt(i) == ' '){
                i++;
            }
            if (i == n){
                break;
            }
            int j = i;
            while (j < n && s.charAt(j) != ' '){
                j++;
            }
            s = reverse(s,i,j - 1);
            //去掉后面de空格！
//            while (s.charAt(j) == ' '){
//                j++;
//            }
            i = j;
        }
        return s.trim();
    }


    public String reverseWords(String s) {
        if (s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        //翻转每一个单词
        //还要添加
        int k = 0;
        for (int i = 0; i < n;i++){
            //去掉前面的空格！
            //但是只是跳过了空格，没有去除多余的空格！
            while (i < n && chars[i] == ' '){
                i++;
            }
            if (i == n){
                break;
            }
            int j = i;
            while (j < n && chars[j] != ' '){
                j++;
            }
            reverse(chars,i,j - 1);
            //去掉后面de空格！
//            while (s.charAt(j) == ' '){
//                j++;
//            }
            //加空格空格！！ 并且进行复制！！
            if (k != 0){
                chars[k++] = ' ';
            }
            while (i < j) chars[k++] = chars[i++];
        }
        String res = String.valueOf(chars);
        res.trim();
        chars = res.toCharArray();
        reverse(chars,0,chars.length - 1);
        return String.valueOf(chars);
    }

    public void reverse(char[] chars , int i ,int j ){
        //这样s是没有变化的！！
        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

    }

    //超级简单de方法！！利用正则表达式  split("\\s")，\\s表示   空格,回车,换行等空白符,
    // +号表示一个或多个的意思,所以...
    class Solution {
        public String reverseWords(String s) {
            if (s == null) {
                return null;
            }

            String[] split = s.trim().split("\\s+");
            if (split.length == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            for (int i = split.length - 1; i >= 1; i--) {
                sb.append(split[i]).append(' ');
            }
            sb.append(split[0]);
            return sb.toString();
        }
    }
}
