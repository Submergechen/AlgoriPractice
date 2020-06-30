package RePractice.SwordOffer0316Twice;

public class Code_0325_11findMin {
    public int solution(int[] arr){
        int length = arr.length - 1;
        if (length < 0){
            return -1;
        }
        //把最后剩下的部分削去以后，就可以开始二分了
        //典型的二分法
        while (length > 0 && arr[length] == arr[0]){
            length--;
        }
        if (arr[length] >= arr[0]){
            return arr[0];
        }
        int l = 0 , r = length;
        while (l < r){
            int mid = l + r << 1;
            if (arr[mid] < arr[r]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return arr[r];
    }
}
