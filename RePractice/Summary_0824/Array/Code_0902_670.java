package RePractice.Summary_0824.Array;

public class Code_0902_670 {
    public int maximumSwap(int num) {
        char[] chars = (num + "").toCharArray();
        int[] last = new int[10];
        for (int i = 0;i < chars.length;i++){
            last[chars[i] - '0'] = i;
        }

        for (int i = 0;i < chars.length;i++){
            for (int j = 9;j > chars[i] - '0';j--){
                if (last[j] > i){
                    char temp = chars[i];
                    chars[i] = chars[last[j]];
                    chars[last[j]] = temp;
                    return Integer.parseInt(chars.toString());
                }
            }
        }
        return num;
    }
}
