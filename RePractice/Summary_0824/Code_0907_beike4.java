package RePractice.Summary_0824;

import java.util.Scanner;

public class Code_0907_beike4 {

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] minusLeft  = new int[n];
        int[] minusRight  = new int[n];
        int[] plusLeft  = new int[n];
        int[] plusRight  = new int[n];

        String[] minus = sc.nextLine().split(" ");
        String[] plus = sc.nextLine().split(" ");
        int minusSum = 0;
        for (String str : minus){
            minusSum += Integer.parseInt(str);
        }
        int plusSum = 0;
        for (String str : plus){
            plusSum += Integer.parseInt(str);
        }
        System.out.println(minusSum - plusSum + 1);
    }
}
