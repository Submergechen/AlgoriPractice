package RePractice.SwordOffer0316Twice;

public class Code_0406_42findGreatestSum {
    public int soluton(int[] nums){
        if (nums == null || nums.length < 1){
            throw new RuntimeException("error!");
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i < nums.length ; i++){
            if (sum < 0){
                sum = 0;
            }
            if (nums[i] < 0){
                max = sum;
            }
            sum += nums[i];
        }
        return Math.max(max , sum);

    }

    //动态规划
    // s 代表以前一个数为终止位置的最大和 ， 如果s > 0  那么就是 s+x  如果s <= 0  那么就是x
    public int solution2(int[] nums){
        int max = Integer.MIN_VALUE;
        int s = 0;
        for (int x: nums){
            if (s < 0) s = 0;
            s += x;
            max = Math.max(s,max);
        }
        return max;
    }
}
