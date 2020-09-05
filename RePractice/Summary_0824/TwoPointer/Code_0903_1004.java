package RePractice.Summary_0824.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class Code_0903_1004 {
    public int longestOnes2(int[] A, int K) {
        int n = A.length;
        int res = 0;
        int left = 0;
        int preSum = 0;
        for (int right = 0;right < n;right++){
            preSum += A[right] == 0 ? 1 : 0;
            if (preSum > K){
                while (left < right && A[left] == 1){
                    left++;
                }
                preSum--;
                left++;
            }
            res = Math.max(res,right - left + 1);

        }
        return res;
    }
    //暴力做超时
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int res = 0;
        for (int i = 0;i < n;i++){
            int curK = K;
            int tempRes = 0;
            for (int j = i;j < n;j++){
                if(A[j] == 1){
                    tempRes++;
                }else{
                    if(curK > 0){
                        tempRes++;
                        curK--;
                    }else{
                        break;
                    }
                }
            }
            res = Math.max(res,tempRes);

        }
        return res;
    }
    //map 还是不行！
    public int longestOnes1(int[] A, int K) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = A.length;
        int res = 0;
        for (int i = 0,j = 0;i < n;){

            while (j < n && map.getOrDefault(0,0) <= K){
                map.put(A[j],map.getOrDefault(A[j],0) + 1);
                j++;
            }
            res = Math.max(res,j - i);
            while (i < n && map.get(0) > K){
                map.put(A[i],map.getOrDefault(A[i],0) - 1);
                i++;
            }

        }
        return res;
    }
}
