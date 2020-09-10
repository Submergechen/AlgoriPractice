package RePractice.Summary_0824;

import java.util.Scanner;

public class Code_0907_beike1 {

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0;i < T;i++){
            String[] str = sc.nextLine().split(" ");
            String[] mei = new String[2];
            String[] niu = new String[2];
            mei[0] = str[0];
            mei[1] = str[1];
            niu[0] = str[2];
            niu[1] = str[3];

            int left = work(mei[0],niu);
            int right = work(mei[1],niu);
            if (left > right){
                System.out.println("left");
            }else if (left < right){
                System.out.println("right");
            }else {
                System.out.println("same");
            }

        }
        


    }
    public static int work(String temp ,String[] strs){
        int score = 0;
        if (temp.equals("J")){
            for (String str : strs){
                if (str.equals("J")){
                    score -= 1;
                }else if (str.equals("B")){
                    score += 1;
                }else {
                    score -= 1;
                }
            }

        }else if (temp.equals("S")){
            for (String str : strs){
                if (str.equals("J")){
                    score += 1;
                }else if (str.equals("B")){
                    score -= 1;
                }else {
                    score -= 1;
                }
            }
        }else {
            //B
            for (String str : strs){
                if (str.equals("J")){
                    score -= 1;
                }else if (str.equals("B")){
                    score -= 1;
                }else {
                    score += 1;
                }
            }
        }
        return score;
    }
}
