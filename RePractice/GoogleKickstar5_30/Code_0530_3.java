package RePractice.GoogleKickstar5_30;

import java.util.Scanner;

public class Code_0530_3 {
    public static void main(String[] agrs){
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int C =1; C <= T;C++){
            String s ,seq;
            s = sc.nextLine();
            seq = sc.nextLine();
            String[] res = seq.split("-");
            System.out.println("Case # " + C);

            int start = 0;
            for (String x : res){
                print(s.substring(start,start + Integer.valueOf(x) - 1));
                start += Integer.valueOf(x);

            }
            System.out.println();
        }
    }
    static String[] nums = new String[]{"zero","two","three","four","five","six",
    "seven","eight","nine"};
    static String[] cnts = new String[]{"","","double","triple","quadruple","quintuple","sextuple",
    "septuple","octuple","nonuple","decuple"};
    public static void print(String s){
        char[] chars = s.toCharArray();
        for (int i = 0;i < s.length();i++){
            //求长度相关的要+1
            int j = i +  1;
            while (j < chars.length && chars[j] == chars[i]){
                j++;
            }
            int len = j - i;
            if (len >= 2 && len <= 10){
                System.out.println(cnts[len] + " " + nums[chars[i] - '0'] + " ");
            }else if (len > 10){
                for (int k = 0;k < len;k++){
                    System.out.println(nums[chars[i] - '0'] + " ");
                }

            }else {
                System.out.println(nums[chars[i] - '0'] + " ");
            }
            i = j - 1;
        }
    }
}
