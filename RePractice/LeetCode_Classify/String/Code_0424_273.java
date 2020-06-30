package RePractice.LeetCode_Classify.String;

import sun.jvm.hotspot.utilities.RBColor;

public class Code_0424_273 {
    String[] small = new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
    "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] decade = new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] big = new String[]{"Billion","Million","Thousand",""};
    public String numberToWords(int num) {
        if (num == 0){
            return small[0];
        }
        StringBuilder res = new StringBuilder();
        for (int i = 1000000000, j = 0;i > 0;i /= 1000,j++){
            if (num >= i){
                res.append(get_part(num / i)).append(big[j]).append(' ');
                num %= i;
            }
        }
        return res.toString().trim();

    }

    public String get_part(int num){
        StringBuilder sb = new StringBuilder();
        //325
        if (num >= 100){
            sb.append(small[num/100]).append(" Hundred ");
            num %= 100;
        }
        if (num == 0){
            return sb.toString();
        }
        //78
        if (num >= 20){
            sb.append(decade[num/10]).append(' ');
            num %= 10;
        }
        if (num == 0){
            return sb.toString();
        }
        sb.append(small[num]).append(' ');
        return sb.toString();
        }

}
