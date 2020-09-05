package RePractice.Summary_0824;

import java.util.Random;
import java.util.Scanner;

public class solution1 {
   public static void main(String[] agrs){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       String[] temp = sc.nextLine().split(" ");
       int len = temp.length;
       int[] nums = new int[len];
       for (int i = 0;i < len;i++){
           nums[i] = Integer.parseInt(temp[i]);
       }
       int res = 0;

       for (int i = 0;i < len;){
           if (i + i < len && nums[i + 1] < nums[i]){
               int j = i + 1;
               while (j < len && nums[j] < nums[i]){
                   j++;
                   res++;
               }
               i = j;
           }else {
               i++;
           }
       }
       if (len == 1){
           res = 1;
       }
       System.out.println(res);
   }
}
