package RePractice.SwordOffer;

//这也是一种递归的风格！！
public class Code_1224_38Permutation {
    public void solution(String str){
        char[] chars = str.toCharArray();
        permutation(chars,0);
    }

    public void permutation(char[] chars , int index){
        /*char[] chars = str.toCharArray();
        for (int i = 0;i < chars.length; i++){
            for (int j = i; j < chars.length;j++){
                swap(chars , i , j);
            }
        }*/
        if (index == chars.length - 1){
            System.out.println(chars);
            //这里一定要retun 否则就会死循环，栈溢出！！
            return;
        }

        int i = index;
        for (;i < chars.length;i++){
            swap(chars,index,i);
            permutation(chars,index + 1);
        }
    }

    public void swap(char[] chars , int i ,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


}
