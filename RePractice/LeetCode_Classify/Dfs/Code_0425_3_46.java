package RePractice.LeetCode_Classify.Dfs;

import java.util.*;

public class Code_0425_3_46 {
    int n;
//    boolean[] is_use;
    Set<Integer> st = new HashSet<>();
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result1 = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute1(int[] nums) {
        if (nums == null){
            return result;
        }
        n = nums.length;
//        is_use = new boolean[n];
        //默认是false？
//        for (int i = 0 ;i < n; i++){
//            is_use[i] =false;
//        }

        dfs(nums,0);
        return result;
    }
    public void dfs1(int[] nums ,int index){
        if (index == n){
            result1.add(path);
            return;
        }
        for (int i = 0;i < n;i++){
            if (!st.contains(nums[i])){
                st.add(nums[i]);
//                is_use[i] = true;
                path.add(nums[i]);
                dfs(nums,index+1);
                //回溯
//                is_use[i] = false;
                st.remove(nums[i]);
                path.remove(path.size() - 1);
            }
        }
    }

    //自己写的！ 之前一直出问题，是因为没有进行回溯！！
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null){
            return result;
        }
        dfs(nums,0);
        return result;
    }

    public void dfs(int[] nums , int index){
        if (index == nums.length - 1){
            List<Integer> res = new ArrayList<>();
            for (int i = 0 ; i < nums.length; i++){
                res.add(nums[i]);
            }
            result.add(res);
        }
        for (int i = index; i < nums.length ;i++){
            swap(nums,i,index);
            dfs(nums,index + 1);
            swap(nums,i,index);
        }

    }

    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
