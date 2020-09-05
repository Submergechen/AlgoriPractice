package RePractice.Summary_0824;

import java.util.Arrays;
import java.util.Scanner;

public class Code_0902_qianxin2 {
    public int house (int[] person) {

        int n = person.length;
        boolean flag = true;
        int[] res = new int[n];
        Arrays.fill(res,1);
        while (flag){
            flag = false;
            for (int i = 0;i < n;i++){
                if (i != n - 1 && person[i] > person[i + 1] && res[i] < res[i + 1]){
                    res[i] = res[i + 1] + 1;
                    flag = true;
                }
                if (i > 0 && person[i] > person[i - 1] && res[i] <= res[i - 1]){
                    res[i] = res[i - 1] + 1;
                    flag = true;
                }

            }
        }

        int ans = 0;
        for (int temp : res){
            ans += temp;
        }
        return ans;
    }
}
