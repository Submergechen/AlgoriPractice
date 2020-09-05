package RePractice.Summary_0824;

public class Code_0904_bilibli1 {
    public int GetMaxConsecutiveOnes (int[] arr, int k) {

        int n = arr.length;
        int res = 0;
        int left = 0;
        int preSum = 0;
        for (int right = 0;right < n;right++){
            preSum += arr[right] == 0 ? 1 : 0;
            if (preSum > k){
                while (left < right && arr[left] == 1){
                    left++;
                }
                preSum--;
                left++;
            }
            res = Math.max(res,right - left + 1);

        }
        return res;

    }
}
