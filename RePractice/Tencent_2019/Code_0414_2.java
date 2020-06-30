package RePractice.Tencent_2019;

import java.util.Scanner;

public class Code_0414_2 {
    //或者用栈做也可以！
    public static void main(String[] agrs){
        int n ;
        String line;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        line = sc.nextLine();
        int zero = 0 , one = 0;
        char[] chars = line.toCharArray();
        for (char x : chars){
            if (x == '1'){
                one++;
            }else {
                zero++;
            }
        }
        System.out.println(Math.abs(one - zero));
    }
}
