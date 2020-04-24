package RePractice.LeetCode_Classify.Binary;

/**
 * 第十题
 */
public class Code_0416_275 {
    /**
     * 也满足两段性， 如果第h个数满足这个性质，那么h-1个数也是满足的，所以左边是满足的，右边是不满足的
     * 如何去判定是否满足， 由于数组的排好序的，所以只要判定最后h个数是否大于h就可以了
     * 判定倒数第h个数是否大于h就行！
     *
     */

    public int solution(int[] nums){
        int l = 0 , r = nums.length;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (nums[nums.length - mid] >= mid){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return r;
    }
}
