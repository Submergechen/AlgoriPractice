package RePractice.Summary_0824.Binary;

public class Code_0827_287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int l = 1,r = n;
        while (l < r){
            int mid = l + r >> 1;
            int count = 0;
            for (int num : nums){
                if (num >= l && num <= mid){
                    count++;
                }
            }
            if (count > mid - l + 1){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
