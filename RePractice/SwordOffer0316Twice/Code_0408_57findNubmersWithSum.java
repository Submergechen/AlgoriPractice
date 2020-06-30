package RePractice.SwordOffer0316Twice;

import java.util.HashMap;
import java.util.Map;

public class Code_0408_57findNubmersWithSum {
    //最优解法
    public int[] solution2(int[] nums , int target){
        Map<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.get(target - nums[i]) != 0){
                return new int[]{nums[i] , target - nums[i]};
            }
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        return new int[]{};
    }
    //暴力做法
    public int[] solution(int[] nums , int target){
        for (int i = 0;i < nums.length ; i++){
            for (int j = 0 ; j < i; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{ nums[i] , nums[j]};
                }
            }
        }
        //一定是有解的，但是规范化最好写一个构造函数
        return new int[]{};

    }
    //自己第一次的解法
    public int[] solution1(int[] nums , int target){

        Map<Integer , Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ;i++){
            int anotherOne = target - nums[i];
            map.put(nums[i] , anotherOne);
            for (int j = i + 1; j < nums.length ; j++){
                if (nums[j] == map.get(nums[i])){
                    //细节错了
                    //return new int[]{map.get(nums[i]) , nums[j]};
                    return new int[]{nums[i] , nums[j]};
                }
            }
        }

        return null;
    }

}
