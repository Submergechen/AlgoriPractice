package RePractice.NewPractice_7022;

import java.util.Stack;

public class Code_String_0728_125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 1){
            return true;
        }
        StringBuffer sb = new StringBuffer();

        char[] chars = s.toCharArray();
        for (char x: chars){
            if (Character.isLetter(x) || Character.isDigit(x)){
                x = Character.toLowerCase(x);
                sb.append(x);
            }
        }
        char[] res = sb.toString().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char x : res){
            stack.push(x);
        }
        for (int i = 0;i < res.length;i++){
            if (res[i] != stack.pop()){
                return false;
            }
        }
        return true;

    }

    public boolean isPalindrome1(String s) {
        if (s == null || s.length() < 1){
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right){
            char tempL = s.charAt(left);
            if (!isValid(tempL)){
                left++;
                continue;
            }
            char tempR = s.charAt(right);
            if (!isValid(tempR)){
                right--;
                continue;
            }
            if (Character.toLowerCase(tempL) != Character.toLowerCase(tempR)){
                return false;

            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isValid(char temp){
        if ((temp >= 'A' && temp <= 'z') || (temp >= '0' && temp <= '9') ){
            return true;
        }
        return false;
    }
}
