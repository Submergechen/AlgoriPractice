package RePractice.SwordOffer;

public class Code_1219_19matchString {
    //递归
    public static boolean process(char[] str , char[] exp , int i ,int j){
        if (j == exp.length){
            return i == str.length;
        }

        if (j + 1 == exp.length || exp[j+1] != '*'){
            return i != str.length && (str[i] == exp[j] || exp[j] =='.') &&
            process(str,exp,i+1,j+1);
        }
        //exp j+1  '*'
        while (i != str.length && (str[i] == exp[j] || exp[j] == '.')){
            if (process(str,exp,i,j+2)){
                return true;
            }
            i++;
        }

        return process(str,exp,i,j+2);
    }
}
