package RePractice.SwordOffer;
// 最后写代码 检查的时候， 特殊样例考虑进去，看代码对不对

//比如这里，如果数组里都是奇数 也错了
public class Code_1221_21reorderOddEven {
    public int[] reorder(int[] arr){
        if (arr.length < 1){
            return arr;
        }

        int i = 0;
        int j = arr.length - 1;

        //写成i > j了
        while (i < j){
            //这里自己也写错了， 如果数组都是奇数 ，就会越界； 所以这里也要加终止条件
            while (i < j &&arr[i] % 2 == 1){
                i++;
            }
            while (i < j && arr[j] % 2 == 0){
                j--;
            }
            if (i > j){
                break;
            }
            swap(arr,i++,j--);
        }
        return arr;
    }

    public void swap(int[] arr,int i ,int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
