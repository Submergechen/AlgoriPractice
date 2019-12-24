package RePractice.SwordOffer;
//待测试！

public class Code_1216_3Duplicate {
    public static boolean duplicate(int arr[]){
        if (arr == null || arr.length < 2){
            return false;
        }

        for (int i = 0; i < arr.length ; i++){
            if (arr[i] == arr[arr[i]]){
                return true;
            }
            while (i != arr[i]){
                int pos = arr[i];
                swap(arr , i , pos);
            }
        }
        return false;
    }


    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,3,1,0,2,5,3};
        int[] B = new int[]{2,3,1,5,6};
        //怎么制造空指针的用例？
        int[] C = new int[]{};
        boolean res = duplicate(A);
        boolean res1 = duplicate(B);
        System.out.println(res);
        System.out.println(res1);
    }
}
