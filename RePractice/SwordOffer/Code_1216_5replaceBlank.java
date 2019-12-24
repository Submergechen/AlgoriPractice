package RePractice.SwordOffer;

public class Code_1216_5replaceBlank {
    public static char[] repalce(String str){
        if (str == null || str.length() < 1){
            return null;
        }
        char[] chars = str.toCharArray();
        int blank_number = 0;
        for (int i = 0; i < chars.length; i++){
            //空格如何表示
            // java里面单个字符一定用 单引号
            if (chars[i] == ' '){
                blank_number++;
            }
        }

        int resSize = chars.length + blank_number*2;
        //我这里写的有点不一样
        char[] res = new char[resSize];
        int p1 = resSize - blank_number * 2 - 1;
        int p2 = resSize - 1;
        while (p1 > 0){
            while (chars[p1] != ' '){
                res[p2--] = chars[p1--];
            }
            res[p2--] = '0';
            res[p2--] = '2';
            res[p2--] = '%';
        }


        return res;
    }

    public static void main(String[] args) {
        char[] res = repalce("we are old");
        System.out.println(res);
    }
}
