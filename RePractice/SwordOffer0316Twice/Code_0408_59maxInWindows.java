package RePractice.SwordOffer0316Twice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Code_0408_59maxInWindows {
    public int[] solution(int[] nums , int k){
        if (nums == null || nums.length < 1){
            return null;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[nums.length - k];
        int index = 0;
        for (int i = 0 ; i < nums.length ; i ++){
            //plus
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i]){
                qMax.pollLast();
            }
            qMax.add(i);
            //minus
            if (qMax.peekFirst() == i - k){
                qMax.pollFirst();
            }
            //result
            if (i >= k - 1){
                //res[j] = arr[qMax.pollFirst()]; 这样不行！因为可能后面连续几个最大值都是它！
                res[index++] = nums[qMax.peekFirst()];

            }
        }
        return res;
    }
}
