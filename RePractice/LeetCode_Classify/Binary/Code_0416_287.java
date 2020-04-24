package RePractice.LeetCode_Classify.Binary;

public class Code_0416_287 {
    // 有n + 1 长度数组，存放了 1- n 的数s
    public int solution(int[] nums) {
        int n = nums.length - 1;
        int l = 1, r = n;
        while (l < r){
            int mid = l + r >> 1;
            int count = 0;
            for (int x : nums){
                if (x >= l && x <= mid){
                    count++;
                }
            }
            if (count > mid - l + 1){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return r;
    }
}
