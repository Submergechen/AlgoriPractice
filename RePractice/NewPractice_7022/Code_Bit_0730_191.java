package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_Bit_0730_191 {

    public int hammingWeight(int n) {
        if (n == 0){
            return 0;
        }
        int res = 0;
        //这里 n有可能是 < 0 的，如果用 >0 那么不会计数！！ 因为高位如果是1  那就是负数！
        while (n != 0){
            n = n & (n - 1);
            res++;
        }
        return res;
    }


}
