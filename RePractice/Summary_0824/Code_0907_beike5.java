package RePractice.Summary_0824;

import java.util.Scanner;

public class Code_0907_beike5 {

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();


        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        int[] minus = new int[2 * n];
        int[] plus = new int[2 * n];
        for (int i = 0;i < 2 * n;i++){
            minus[i] = Integer.parseInt(str1[i]);
            plus[i] = Integer.parseInt(str2[i]);
        }
        int l = 0;
        int r = 100000;
        while (l < r){
            int mid = l + r >> 1;
            if (isValid(minus,plus,mid,2 * n)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
    static boolean isValid(int[] minus,int[] plus,int blood , int n ){
        for (int i = n/ 2 - 1,j = n / 2 ;i >= 0 || j < n; ){
            //right
            if (i >= 0 && j < n){
                if (minus[i] > blood && minus[j] < blood){
                blood = blood - minus[j] + plus[j];
                j++;
            }else if (minus[i] < blood &&minus[j] > blood ){ //left
                blood = blood - minus[i] + plus[i];
                i--;
            }else if (minus[i] < blood && minus[j] < blood){ //zuida
                int minIndex = plus[i] - minus[i] < plus[j] - minus[j] ? i: j;
                if (minIndex == i){
                    blood = blood - minus[i] + plus[i];
                    i--;
                }else {
                    blood = blood - minus[j] + plus[j];
                    j++;
                }
            }else {
                return false;
                }
            }else if (i >= 0){
                if (minus[i] > blood){
                    return false;
                }else {
                    blood = blood - minus[i] + plus[i];
                    i--;
                }
            }else {
                if (minus[j] > blood){
                    return false;
                }else {
                    blood = blood - minus[j] + plus[j];
                    j++;
                }
            }

        }



        return true;
    }
}
