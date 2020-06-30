package RePractice.SwordOffer0316Twice;

import class_08.Test;

public class Code_0413_67strToInt {
    public int solution(String str){
        //这里很奇怪， str == "" 和str.length == 0有什么区别吗
        if (str == ""||str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int k = 0;
        long number = 0;
        while (k < chars.length && chars[k] == ' '){
            k++;
        }
        boolean is_minus = false;
//        if (chars[k++] == '-'){
//            is_minus = true;
//        }
//        if (chars[k] == '+'){
//            k++;
//        }else {
//            is_minus = true;
//            k++;
//        }
        //有可能是没有正负号的
        if (chars[k] == '+'){
            k++;
        }else if(chars[k] == '-') {
            is_minus = true;
            k++;
        }
        while (k < chars.length && chars[k] >= '0' && chars[k] <= '9'){
            number = number * 10 + chars[k] - '0';
            k++;
        }
        if (is_minus){
            number *= -1;
        }
        if (number > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if (number < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)number;
    }
}
