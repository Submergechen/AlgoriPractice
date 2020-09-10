package RePractice.Summary_0824;

import java.util.Arrays;
import java.util.Scanner;

public class Code_0906_xiaohongshu1 {

    static int[] subSort(int[] arr) {


    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int n = 0;
        n = Integer.parseInt(in.nextLine().trim());
        int[] arr = new int[n];
        int temp;
        for(int i = 0; i < n; i++) {
            temp = Integer.parseInt(in.nextLine().trim());
            arr[i] = temp;
        }
        int[] nums = new int[arr.length];
        for (int i = 0;i < n;i++){
            nums[i] = arr[i];
        }
        Arrays.sort(arr);
        int start = -1;
        for (int i = 0;i < n;i++){
            if (arr[i] != nums[i]){
                start = i;
                break;
            }
        }
        int end = -1;
        for (int i = n - 1;i >= 0;i--){
            if (arr[i] != nums[i]){
                end = i;
                break;
            }
        }
        if (n == 0){
            System.out.println(-1);
            System.out.println(-1);
        } else {
            System.out.println(start);
        System.out.println(end);
        }


    }

}
