package RePractice.SwordOffer0316Twice;

import java.util.Arrays;
import java.util.Comparator;

public class Code_0406_45printMinNumber {

    public String solution(int[] nums){
        if (nums == null){
            return null;
        }
        Integer[] arr  = new Integer[nums.length];
        for (int i = 0;i < arr.length; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return ("" + o1 + o2).compareTo("" +o2 + o1);
            }
        });

        String res = "";
        for (Integer x : arr){
            //要不要加。tostring（）这个方法
            //可以bu加 ，字符串拼接可以不要
            res += x;
        }
        return res;

    }
}

