package RePractice.Pinduoduo2019;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Code_0521_1 {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        //变成小写！
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        for (char c = 'a'; c <= 'z';c++){
            int k = 0;
            while (k < str.length() && chars[k] != c) k++;
            Set<Character> set = new HashSet<>();
            for (int i = k + 1;i < str.length();i++){
                set.add(chars[i]);
            }
            boolean can = true;

            for (int i = 0;i < k;i++){
                if (!set.contains(chars[i])){
                    can = false;
                    break;
                }
            }
            if (can){
                System.out.println(c);
                break;
            }
        }
    }
}
