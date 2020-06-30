package RePractice.LeetCode_Classify.SingleStackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Code_0501_239 {
//    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//    Output: [3,3,5,5,6,7] 8 3 6
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
//        Deque<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList();
        int j = 0;
        for (int i = 0;i < nums.length;i++){
            //puls
//            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]){
//                qmax.peekLast();
//            }
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]){
                qmax.pollLast();
            }
            qmax.add(i);
            //minus
            if (i - qmax.peekFirst() == k){
                qmax.pollFirst();
            }
            //result
            if (i >= k - 1){
                res[j++] = nums[qmax.peekFirst()];

            }

        }
        return res;
        //puls
        //minus
    }
}
