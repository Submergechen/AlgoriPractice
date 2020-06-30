package RePractice.LeetCode_Classify.SingleStackQueue;

public class Code_0430_167 {
    //解法1 暴力
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0 ; i < numbers.length; i++){
            for (int j = 0; j < i;j ++){
                if (numbers[i] + numbers[j] == target){
                    return new int[]{j+1 ,i+1};
                }
            }
        }
        return new int[]{-1,-1};
    }
    //优化，双指针算法
    public int[] twoSum1(int[] numbers, int target) {
        //为什么是i - 1 > j是因为 i和j 不同取同一个数， 不能相等！
        for (int j = 0 , i = numbers.length - 1; j < numbers.length ; j++){
            while (i - 1 > j && numbers[i - 1] + numbers[j] >= target){
                i--;
            }
            if (numbers[i] + numbers[j] == target){
                return new int[]{j+1, i+1};
            }
        }
        return new int[]{-1,-1};
    }
}
