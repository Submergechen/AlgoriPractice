package RePractice.Summary_0824;

import java.util.Stack;

public class Code_0826_20 {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(')');
            }else if (s.charAt(i) == '{'){
                stack.push('}');
            }else if (s.charAt(i) == '['){
                stack.push(']');
            }else{
                if (stack.isEmpty() || s.charAt(i) != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
