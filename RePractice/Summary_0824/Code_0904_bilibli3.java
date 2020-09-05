package RePractice.Summary_0824;

import java.util.ArrayList;
import java.util.List;

public class Code_0904_bilibli3 {

    public int GetFragment (String str) {
        // write code here
        int len = str.length();
        if(len == 0){
            return 0;
        }
        char[] chars = str.toCharArray();

        int left = 1;
        char temp = str.charAt(0);
        int n = 1;
        while (left < len){
            if (chars[left] != temp){
                temp = chars[left];
                n++;
            }
            left++;
        }
        return left / n;
    }
}
