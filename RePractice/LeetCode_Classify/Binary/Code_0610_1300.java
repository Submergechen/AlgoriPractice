package RePractice.LeetCode_Classify.Binary;

public class Code_0610_1300 {
    public int findBestValue(int[] arr, int target) {
        int l = 1;
        int r = -1;
        for (int x : arr){
            if (r < x){
                r = Math.max(r , x);
            }
        }
        //二分法先找到大于target的最小k
        while (l < r){
            int mid = l + r >> 1;
            if (check(arr,mid) >= target) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        //但是有可能k-1是那个正确值！ 特判一下！
        if (target - check(arr,l - 1) <= check(arr,l) - target ){
            return l - 1;
        }
        return l;
        //处理一下边界
    }
    public int check(int[] arr , int mid){
        int sum = 0;
        for (int x : arr){
            if (x >= mid){
                sum += mid;
            }else {
                sum += x;
            }
        }
        return sum;
    }
}


class Solution {
    public int findBestValue(int[] arr, int target) {
        int low = 1, high = max(arr)+1;
        while (low < high) {
            int mid = low + (high-low)/2;
            int sum = sumArray(arr, mid);
            if (sum <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (target - sumArray(arr, low-1) > (sumArray(arr, low) - target)) {
            return low;
        }
        return low-1;
    }

    public int sumArray(int[] arr, int k) {
        int sum = 0;
        for (int num : arr) {
            if (num > k) sum += k;
            else sum += num;
        }
        return sum;
    }

    public int max(int[] arr) {
        int high = 1;
        for (int num : arr) {
            if (num > high) high = num;
        }
        return high;
    }
}