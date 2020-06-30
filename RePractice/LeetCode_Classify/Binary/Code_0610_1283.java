package RePractice.LeetCode_Classify.Binary;

public class Code_0610_1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1,r = 10000000;
        while (l < r){
            int mid = l + r >> 1;
            if (check(nums,mid,threshold)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] nums, int mid ,int threshold){
        int sum = 0;
        for (int x : nums){
            sum += (x + mid - 1) / mid;
        }
        if (sum <= threshold){
            return true;
        }
        return false;
    }
}
