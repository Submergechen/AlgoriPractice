package RePractice.Summary_0824;

import java.util.Scanner;

public class Code_0907_zte2 {

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int k = 0;k < T;k++){
            int n = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[n];
            String[] temp = sc.nextLine().split(" ");
            for (int i = 0 ;i < n;i++) {
                    nums[i] = Integer.parseInt(temp[i]);
            }
            int asc = 0;
            for (int i = 1;i < n;i++){
                if (nums[i] < nums[i - 1]){
                    asc  += 1;
                }
            }
            int desc = 0;
            for (int i = 1;i < n;i++){
                if (nums[i] > nums[i - 1]){
                    desc += 1;
                }
            }
            System.out.println(Math.min(asc,desc));
        }

    }



}
