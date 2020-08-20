package RePractice.NewPractice_7022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code_Array_0728_121 {
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 1){
            return 0;
        }
        int res = 0;
        int minV = prices[0];
        int maxV = prices[0];
        for (int i = 0;i < len;i++){
            if (minV > prices[i]){
                minV = prices[i];
                maxV = prices[i];
            }
            if (maxV < prices[i]){
                maxV = prices[i];
            }
            if (maxV - minV > res){
                res = maxV - minV;
            }

        }
        return res;
    }

//on的平方
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0;i < prices.length - 1;i++){
            for (int j = i + 1;j < prices.length; j++){
                res = Math.max(res,prices[j] - prices[i]);
            }
        }
        return res;
    }

}
