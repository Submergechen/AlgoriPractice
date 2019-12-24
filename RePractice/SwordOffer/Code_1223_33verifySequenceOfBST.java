package RePractice.SwordOffer;

//递归！！
public class Code_1223_33verifySequenceOfBST {

    public boolean verify(int[] sequence){
        if (sequence == null || sequence.length <= 0){
            return false;
        }
        return process(sequence , 0 , sequence.length - 1);
    }

    public boolean process(int[] sequence , int left , int right){
        //递归条件里 一定要有 true 和 false的情况  ，我这里没有写true的情况
        /*if (sequence == null || sequence.length <= 0){
            return false;
        }*/
        if (left >= right){
            return true;
        }
        int root = sequence[right];
        //int lessCount = left;  经常犯错的地方，如果= left，那么后面就不应该是 left+lessCount
        int less = left;
        for (int i = left; i < right ; i++){
            if (sequence[i] > root){
                break;
            }
            less++; //3
        }
        int largeCount = less + 1;
        for (int i = less + 1; i < right ; i++){
            if (sequence[i] < root){
                return false;
            }
        }

        //return process(sequence , left, left + lessCount) && process(sequence , lessCount + 1 ,right - 1);
        //相对位置搞错里！！
        return process(sequence , left, less) && process(sequence , less + 1 ,right - 1);
    }
}
