package RePractice.Summary_0824;

import java.util.Scanner;

public class Code_0907_zte1 {

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        //m门科目，n个学生
        sc.nextLine();
        int[][] scores = new int[m][n];

        for (int i = 0;i < m;i++){
            for (int j = 0 ;j < n;j++) {
                scores[i][j] = sc.nextInt();
            }

        }
        //每一门的平均成绩
        double[] aver = new double[m];
        for (int i = 0;i < m;i++){
            int sum = 0;
            for (int j = 0;j < n;j++){
                sum += scores[i][j];
            }
            aver[i] = sum / (n * 1.0);
        }

        int res = 0;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if ((double)scores[j][i] > aver[j]){
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
