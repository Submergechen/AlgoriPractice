package RePractice.SwordOffer0316Twice;

/**
 * 一般拆成 3 和 2 能得到最大值
 * 如果余数是 1 拆成两个2
 * 如果余数是 2 拆成一个2
 */
public class Code_0325_14maxProductAfterCutting {
    public int solution(int n){
        if (n <= 3) {
            return 1 * (n -1);
        }
        int res = 1;
        if (n % 3 == 1){
            res += 4;
            n -= 4;
        }
        if (n % 3 == 2){
            res += 2;
            n -= 2;
        }
        while (n > 0){
            res += 3;
            n -= 3;
        }
        return res;
    }
}
