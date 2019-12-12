package RePractice.LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class Code_1212_78subSets {
    List<List<Integer>>  res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<Integer>();
        process(nums,0,cur);
        return res;
    }

    public  void process(int[] nums , int index ,List<Integer> cur){
        if (index == nums.length){
            //这句出问题了，为什么出问题呢
            //为什么不能加 static
            //res.add(cur);
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(nums[index]);
        //直接写的话 会报错！ list.add()方法是boolean类型
        //process(nums,index + 1, cur.add(nums[index]));
        process(nums,index+1,cur);
        cur.remove(cur.size() - 1);
        process(nums,index + 1,cur);
    }
}
