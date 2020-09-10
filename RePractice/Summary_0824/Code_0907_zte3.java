package RePractice.Summary_0824;

import java.util.Scanner;
import java.util.Stack;

public class Code_0907_zte3 {

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
            Stack<Integer> stack = new Stack<>();

            int asc = 0;
            for (int i = 0;i < n;i++){
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                    stack.pop();
                    asc++;
                }
                stack.push(i);
            }

            int desc = 0;
            for (int i = 0;i < n;i++){
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                    stack.pop();
                    desc++;
                }
                stack.push(i);
            }
            System.out.println(Math.min(asc,desc));
        }

    }



}
