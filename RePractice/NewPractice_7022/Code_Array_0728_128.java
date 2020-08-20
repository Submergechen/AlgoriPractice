package RePractice.NewPractice_7022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code_Array_0728_128 {


    //hashset
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int res = 0;
        int l = 0;
        for (int num : nums){
            if (!set.contains(num - 1)){
                l = 1;
                while (set.contains(num + l)){
                    l++;
                }
                res = Math.max(res,l);
            }
        }
        return res;
    }
    //online
    public int longestConsecutive2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums){
            if (map.containsKey(num)){
                continue;
            }
            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            if (left > 0 && right > 0){
                map.put(num - left,left + right + 1);
                map.put(num + right,left + right + 1);
                map.put(num,left + right + 1);
            }else if (left > 0){
                map.put(num - left,left + 1);
                map.put(num,left + 1);
            }else if (right > 0){
                map.put(num + right,right + 1);
                map.put(num,right + 1);
            }else {
                map.put(num,1);
            }
        }
        for (int num : nums){
            res = Math.max(res,map.get(num));
        }
        return res;
    }
    public int longestConsecutive4(int[] num) {

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }

        return res;
    }
    //如果都是正数 可以这么做！
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        int maxV = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length;i++ ){
            maxV = Math.max(maxV,nums[i]);
        }
        int[] bucket = new int[maxV + 1];
        for (int num : nums){
            bucket[num] = 1;
        }
        int res = 1;
        for (int i = 0;i < maxV;i++){
            int k = i;
            while (k > 0 && bucket[k] == 1 && bucket[k + 1] == 1){
                k++;
            }
            if (k - i + 1 > res){
                res = k - i + 1;
            }
            i = k;
        }
        return res;




    }

}
