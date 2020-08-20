package RePractice.NewPractice_7022;

public class Code_Bit_0810_231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
        int res = 0;
        while (n != 0){
            n = (int)((long)n & (n - 1L));
            res++;
        }
        return res == 1;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n <= 0){
            return false;
        }
        return (n & (n - 1)) == 0;
    }


}
