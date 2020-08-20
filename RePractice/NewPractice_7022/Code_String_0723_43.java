package RePractice.NewPractice_7022;

public class Code_String_0723_43 {

    //用数组 指针
    public String multiply(String num1, String num2) {

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int n1 = chars1.length;
        int n2 = chars2.length;

        char[] res = new char[n1 + n2];

        for (int j = n2 - 1; j >= 0;j--){
            for (int i = n1 - 1;i >= 0;i--){
                int temp = (chars1[n1] - '0') * (chars2[n2] - '0');
            }
        }
        int carry = 0;
        int cur = resLength - 1;
        int ans = 0;

        while (point2 >= 0){
            point1 = chars1.length - 1;
            carry = 0;
            while (point1 >= 0){
                int temp = ((point1 >= 0 ? chars1[point1] : '0') - '0') * (chars2[point2] - '0')
                        + carry;
                carry = temp / 10;
                point1--;
                ans = (temp % 10) * 10 + ans;
            }
        }



        while (point1 >= 0 || point2 >= 0 || carry > 0){
            int temp = (point1 >= 0 ? chars1[point1] : '0') - '0' * (point2 >= 0 ? chars2[point2] : '0') - '0'
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
