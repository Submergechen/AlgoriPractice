package RePractice.SwordOffer;

public class Code_1218_15numberOf1 {
    public int getNubmberOf1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int getNumb(int n ){
        int res = 0;
        int flag = 1;
        while (n != 0){
             if ((n & flag) == 1){
                 res++;
             }
            flag = flag << 1;
        }
        return res;
    }
}
