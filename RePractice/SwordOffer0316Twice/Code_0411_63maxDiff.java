package RePractice.SwordOffer0316Twice;

public class Code_0411_63maxDiff {
    public int solution(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }
        int min = nums[0];
        int maxDiff = 0;
        for (int i = 1; i < nums.length ;i++){
            if (nums[i] - min > maxDiff){
                maxDiff = nums[i] - min;
            }
            if (nums[i] < min){
                min = nums[i];
            }

        }
        return maxDiff;
    }
}
