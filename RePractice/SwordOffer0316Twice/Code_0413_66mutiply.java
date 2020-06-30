package RePractice.SwordOffer0316Twice;

public class Code_0413_66mutiply {
    public int[] solution(int[] A){
        if (A == null || A.length < 1){
            return new int[]{};
        }
        int len = A.length;
        int[] B = new int[len];
        int mul = 1;
        for (int i = 0 ; i < len; i++){
            B[i] = mul;
            mul *= A[i];
        }
        mul = 1;
        for (int i = len - 1; i >= 0; i--){
            B[i] *= mul;
            mul *= A[i];
        }
        return B;
    }
}
