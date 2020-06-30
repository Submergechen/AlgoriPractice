package RePractice.SwordOffer0316Twice;

public class Code_0402_33verifySequenceBST {
    public boolean solution(int[] sequence){
        if (sequence == null || sequence.length == 0){
            return false;
        }

        return process(sequence , 0 , sequence.length - 1);
    }

    public boolean process(int[] sequence , int start , int end){
        // start = 0 , end = 6
        if (start >= end){
            return true;
        }
        int root = sequence[end];
        //int leftLen = 0;
        int leftEnd = start;
        // 这两步可以合并
//        for (int i = k; i <= end - 1 ; i++){
//            if (sequence[i] < root){
//                leftLen++; // 2
//            }
//        }
        while (leftEnd < end && sequence[leftEnd] < root ) {
            leftEnd++;
        }
        for (int i = leftEnd ; i < end ; i++){
            if (sequence[i] < root){
                return false;
            }
        }
//        for (int j = start; j <= start + leftLen; j++){
//            if (sequence[j] > root){
//                return false;
//            }
//        }
//        for (int j = start + leftLen + 1; j < end; j++){
//            if (sequence[j] < root){
//                return false;
//            }
//        }
//        return process(sequence , start , start + leftLen) &&
//                process(sequence , start + leftLen + 1 , end - 1);
        return process(sequence,start, leftEnd - 1) && process(sequence , leftEnd, end - 1);
    }
}



