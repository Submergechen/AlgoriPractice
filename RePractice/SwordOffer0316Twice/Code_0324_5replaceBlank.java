package RePractice.SwordOffer0316Twice;

public class Code_0324_5replaceBlank {
    //这里的str[]  长度很长，后面有很多空字符串
    // length 为 capacity
    public static void solution(char[] string ,int length){
        if (string == null || string.length < 1){
            return;
        }
        int ori_length = 0;
        int blank_count = 0;
        for (char i : string){
            if (i == ' '){
                blank_count++;
            }
            ori_length++;
        }
        int new_length = ori_length + blank_count * 2;
        if (new_length > length){
            return;
        }
        int p2 = new_length;
        int p1 = ori_length;

        while (p1 != p2){
            if (string[p1] == ' '){
                string[p2--] = '0';
                string[p2--] = '2';
                string[p2--] = '%';

            }else {
                string[p2--] = string[p1];
            }
            --p1;

        }
    }
}
