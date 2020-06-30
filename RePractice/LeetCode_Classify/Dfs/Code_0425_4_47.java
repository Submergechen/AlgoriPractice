package RePractice.LeetCode_Classify.Dfs;

import java.util.*;

public class Code_0425_4_47 {
    int n;
    boolean[] st;
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int[] temp;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        st = new boolean[n];
        temp = new int[n];

        Arrays.sort(nums);
        dfs(nums,0 ,0);
        return res;
    }
    //u 代表枚举到第几位数！
    //st代表这个位置有没有被用过？
    public void dfs(int[] nums , int u , int start){
        if (u == n){
            List<Integer> result =  new ArrayList<>(); ;
            for (int i = 0 ;i < n ; i++){
                result.add(temp[i]);
            }
            res.add(result);
            return;
        }

        for (int i = start; i < nums.length ;i++){
            if (!st[i]){
                st[i] = true;
                //u这位数！ 放到i位置
                //不用取消，应该会覆盖掉！
                temp[i] = nums[u];
                dfs(nums , u + 1 ,u + 1 < n && nums[u] == nums[u + 1] ? i + 1 : 0);
                st[i] = false;
            }
        }
    }
}
