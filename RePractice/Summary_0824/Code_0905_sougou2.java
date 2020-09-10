package RePractice.Summary_0824;

public class Code_0905_sougou2 {
    public int getHouses (int t, int[] xa) {
        // write code here
        int res = 2;
        int n = xa.length;
        int[] x = new int[n / 2];
        int[] a = new int[n / 2];
        int index = 0;
        for (int i = 0;i < xa.length;i+=2){
            x[index] = xa[i];
            a[index] = xa[i + 1];
        }
        if (n == 1){
            return res;
        }
        for (int i = 0;i < n - 1;i++){
            double lo = (double)x[i] + a[i] / 2.0;
            double hi = (double)x[i + 1] - a[i + 1] / 2.0;
            if (hi - lo < t)continue;
            if (hi - lo == t){
                res++;
            }else {
                res += 2;
            }

        }
        return res;
    }
}
