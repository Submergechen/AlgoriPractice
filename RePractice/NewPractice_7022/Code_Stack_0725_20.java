package RePractice.NewPractice_7022;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Code_Stack_0725_20 {




    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length;i++){
            if (chars[i] == '('){
                stack.push(')');
            }else if (chars[i] == '{'){
                stack.push('}');
            }else if (chars[i] == '['){
                stack.push(']');
            }else {
                if (stack.isEmpty() || chars[i] != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();




    }


    public boolean isValid1(String s) {
        if (s == null){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            if (chars[i] == ')'){
                if (stack.peek() == '('){
                    stack.pop();
                    continue;
                }else {
                    return false;
                }
            }else if (chars[i] == '}'){
                if (stack.peek() == '{'){
                    stack.pop();
                    continue;
                }else {
                    return false;
                }
            }else if (chars[i] == ']'){
                if (stack.peek() == '['){
                    stack.pop();
                    continue;
                }else {
                    return false;
                }
            }else {
                stack.push(chars[i]);
            }
        }
        return true;

    }

}
