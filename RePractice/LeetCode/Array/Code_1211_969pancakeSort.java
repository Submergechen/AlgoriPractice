package RePractice.LeetCode.Array;

import java.util.ArrayList;
import java.util.List;
//写
public class Code_1211_969pancakeSort {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = A.length - 1; i > 0; i--){
            int maxIndex = getMax(A ,0 , i);
            if (maxIndex != 0){
                reverse(A , maxIndex + 1);
                res.add(maxIndex + 1);
            }
            // 把i改成i+1就过了
            reverse(A , i+1);
            res.add(i);
        }
        return res;
    }

    public static int getMax(int[] arr , int start ,int end){
        int maxIndex = start;
        for (int i = start; i <= end ; i++){
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        return maxIndex;
    }
    public static void reverse(int[] arr ,int num){
        if (num > arr.length){
            throw new RuntimeException("数据错误");
        }
        int middle = (num -1) / 2;
        for (int i = 0; i <= middle ; i++){
            swap(arr , i , num - i - 1);
        }
    }

    public static void swap(int[] arr, int i , int j){
        /*arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
