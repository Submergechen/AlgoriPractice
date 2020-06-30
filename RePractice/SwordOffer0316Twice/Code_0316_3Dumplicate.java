package RePractice.SwordOffer0316Twice;

/**
 * 和leetcode442题很像，只不过那个是从1开始，用正负的方法来做，这个是从0开始 所以不可以
 * 第二情况用到了经典二分法！
 */
public class Code_0316_3Dumplicate {

    /*public static void solution1(int[] arr){
        int l = 1 , r = arr.length - 1;
        while (l < r){
            int mid = (l + r) << 1;
            int sum = 0;
            for (int i : arr){
                sum += (i >= l && i <= mid ? 1 : 0);
            }
            if (sum > mid - l + 1){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
    }*/
    public static int solution(int[] arr){
        if (arr.length < 2 || arr == null){
            return -1;
        }

        for (int i = 0; i < arr.length;i++){
            if (arr[i] < 0 || arr[i] > arr.length){
                return -1;
            }
        }
        for (int i = 0; i < arr.length ; i++){
            while (i != arr[i] && arr[i] != arr[arr[i]]){
                swap(arr,i,arr[i]);
            }
            if (i != arr[i] && arr[i] == arr[arr[i]]){
                return arr[i];
            }
        }
        return -1;
    }

    public static void swap(int[] arr ,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //第二种情况，1-n范围内，n+1 个数 ,二分法！
    public static void solution2(int[] arr){
        int l = 1, r = arr.length - 1;

        while (l < r){
            int mid = (l + r) >> 1;
            int sum = 0;
            for (int i : arr){
                sum += (i >= l && i <=mid ? 1: 0);
            }
            //这里 mid - l + 1 是个数！
            if (sum > mid - l + 1){
                r = mid;
            }else {
                l = mid + 1;
            }

        }
    }
}
