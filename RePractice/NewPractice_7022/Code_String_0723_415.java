package RePractice.NewPractice_7022;

public class Code_String_0723_415 {

    //用数组 指针
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int point1 = chars1.length - 1;
        int point2 = chars2.length - 1;
        int resLength = Math.max(chars1.length,chars2.length) + 1;
        int[] res = new int[resLength];
        int carry = 0;
        int cur = resLength - 1;

        while (point1 >= 0 || point2 >= 0 || carry > 0){
            int temp = (point1 >= 0 ? chars1[point1] : '0') - '0' + (point2 >= 0 ? chars2[point2] : '0') - '0'
                    + carry;
            res[cur] = temp % 10;
            carry = temp / 10;
            if (point1 >= 0){
                point1--;
            }
            if (point2 >= 0){
                point2--;
            }
            cur--;
        }
        StringBuffer sb = new StringBuffer();
        boolean is_0 = false;
        for (int i = 0;i < resLength;i++){
            if (i == 0 && res[i] == 0){
                continue;
            }
            sb.append(res[i]);
        }
    return sb.toString();
    }
}
