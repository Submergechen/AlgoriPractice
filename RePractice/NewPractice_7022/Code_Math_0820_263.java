package RePractice.NewPractice_7022;

public class Code_Math_0820_263 {
    public boolean isUgly(int num) {
        if (num == 0){
            return false;
        }
        int[] arr = new int[]{2,3,5};
        for (int temp : arr){
            while (num % temp == 0){
                num /= temp;
            }
        }
        return num == 1;
    }
}
