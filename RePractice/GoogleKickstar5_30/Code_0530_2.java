package RePractice.GoogleKickstar5_30;

import javax.swing.*;
import java.util.Scanner;

public class Code_0530_2 {
    static int N = 110;
    static String[] cards = new String[N];
    static int n;
    public static void main(String[] agrs){
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int C = 1;C <= T;C++){
            n = sc.nextInt();
            for (int i = 0;i < n;i++){
                //可以读包括空格在内的字符串
                cards[i] = sc.nextLine();
            }
            int res = 0;
            //插入排序
            for (int i = 1;i < n;i++){
                //怎么比较一个字符串， 首字符排序
                if (cards[i].compareTo(cards[i-1]) < 0){
                    for (int j = i; j != 0;j--){
                        if (cards[j].compareTo(cards[j-1]) < 0){
                            swap(cards[j],cards[j-1]);
                        }
                    }
                    res++;
                }
            }
            System.out.println("Case #" + C + ":" + res);
        }

    }
    public static void swap(String i, String j){
        String temp = i;
        i = j;
        j = temp;
    }
}
