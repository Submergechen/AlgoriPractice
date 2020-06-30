package RePractice.SwordOffer0316Twice;

public class Code_0324_4Find {
    public static boolean solution(int[][]arr, int aim){
        if (arr == null || arr.length < 1 || arr[0].length < 1){
            return false;
        }
        int R = 0;
        int C = arr[0].length - 1;

        while (C >= 0 && R < arr.length){
            if (arr[R][C] == aim){
                return true;
            }else if (aim > arr[R][C]){
                C--;
            }else {
                R++;
            }
        }
        return false;
    }
}
