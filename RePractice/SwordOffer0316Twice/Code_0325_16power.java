package RePractice.SwordOffer0316Twice;

public class Code_0325_16power {
    public double power(double base , int exp){
        double res = 1;
        for (int i = 0 ; i < Math.abs(exp); i++){
            base *= base;
        }
        if (exp < 0){
            res = 1 / res;
        }
        return res;
    }
}
