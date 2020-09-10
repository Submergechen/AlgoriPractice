package RePractice.Summary_0824;

import java.util.Scanner;

public class Code_0907_xiaomi1 {

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            int n = str.length();
            if (n < 8 || n > 120){
                System.out.println("1");
                continue;
            }

            boolean hasDigit = false;
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasOther = false;
            for (int i = 0;i < n;i++){


                char chr = str.charAt(i);
                if (Character.isDigit(chr)){
                    hasDigit = true;
                }else if (chr >= 'A' && chr <= 'Z'){
                    hasUpper = true;
                } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                    hasLower = true;
                }else {
                    hasOther = true;
                }
//                if ((str.charAt(i) >= 0 && str.charAt(i) <= 47) ||
//               (str.charAt(i) >= 58 && str.charAt(i) <= 64) ||
//                (str.charAt(i) >= 91 && str.charAt(i) <= 96) ||
//                (str.charAt(i) >= 123 && str.charAt(i) <= 126)){
//                    hasOther = true;
//                }
//                if (!Character.isUpperCase(str.charAt(i)) && !Character.isLowerCase(str.charAt(i))
//                && Character.isDigit(str.charAt(i))){
//                    hasOther = true;
//                }
            }
            if (hasDigit && hasLower && hasOther && hasUpper){
                System.out.println("0");
            }else {
                System.out.println("2");
            }

        }
        }

    }
}
