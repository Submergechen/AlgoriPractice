package RePractice.SwordOffer0316Twice;

/**
 * 忘记考虑鲁棒性！
 * 如果是 1 2 4 6 8 就错了
 *  这里的 left < right 很关键！
 */
public class Code_0401_21reorderOddEven {
    public void solution(int[] arr){
        if (arr == null || arr.length < 1){
            return;
        }
        int len = arr.length - 1;
        int left = 0 , right = len;

        while (left < right){
            //如果是 1 2 4 6 8 就出错！
//            while (arr[left] % 2 != 0){
//                left++;
//            }
            while (left < right && (arr[left] % 2 != 0)){
                left++;
            }
            while (left < right && (arr[right] % 2 != 1)){
                right--;
            }
            //不一定会交换
            //swap(arr, left , right);
            if (left < right){
                swap(arr , left , right);
            }
        }
    }

    public void swap(int[] arr , int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //最终精炼版本
    public void conclusion(int[] arr){
        if (arr == null || arr.length < 1){
            return;
        }
        int len = arr.length - 1;
        int left = 0 , right = len;

        while (left < right){
            while (left < right && isRight(arr[left])){
                left++;
            }
            while (left < right && !isRight(arr[right])){
                right--;
            }
            if (left < right){
                swap(arr,left,right);
            }

        }

    }

    public boolean isRight(int value){
        return value % 3 == 0 ;
    }
}
