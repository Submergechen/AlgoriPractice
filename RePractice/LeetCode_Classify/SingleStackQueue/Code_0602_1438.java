package RePractice.LeetCode_Classify.SingleStackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Code_0602_1438 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int res = 0;
        for (int i = 0,j = 0;i < n;i++){
            while (!max.isEmpty() && nums[i] >= nums[max.peekLast()]){
                max.pollLast();
            }
            max.add(i);
            while (!min.isEmpty() && nums[i] <= nums[min.peekLast()]){
                min.pollLast();
            }
            min.add(i);
            while (!max.isEmpty() && !min.isEmpty() &&(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit ){
                j++;
                while (!max.isEmpty() && max.peekFirst() < j){
                    max.pollFirst();
                }
                while (!min.isEmpty() && min.peekFirst() < j){
                    min.pollFirst();
                }


            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
