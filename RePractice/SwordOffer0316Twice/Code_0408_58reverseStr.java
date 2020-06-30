package RePractice.SwordOffer0316Twice;

public class Code_0408_58reverseStr {
    //未完成！
    public String solution(String s){
        if (s == null || s.length() < 1){
            return s;
        }
        char[] chars = s.toCharArray();
        reverse(chars,0,chars.length - 1);


        //真的不要再用len长度来定义了！ 直接从左边端点开始找！

//        int len = 0;
//        for (int i = 0;i < chars.length; i++){
//            if (chars[i] != ' '){
//                len++;
//            }else {
//
//                if (len != 1) reverse(chars,i-1-len,i-1);
//                len = 0;
//            }
//        }
        for (int i = 0;i < chars.length ; i++){
            int j = i;
            while (j < chars.length && chars[j] != ' '){
                j++;
            }
            reverse(chars,i,j-1);
        }
        //这个方法不行
        // return chars.toString();
        return String.valueOf(chars);
    }


    //reverse
    public void reverse(char[] chars , int left , int right){
        if (chars[left]==' ' || chars[right] == ' '){
            return;
        }
        while (left <= right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
