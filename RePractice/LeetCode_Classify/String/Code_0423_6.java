package RePractice.LeetCode_Classify.String;

public class Code_0423_6 {
    //2(n-1)
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            if (i == 0 || i == numRows - 1){
                for (int j = i; j < chars.length; j+= 2*(numRows-1)){
                    sb.append(chars[j]);
                }
            }else {
                for (int j = i, k = 2 *(numRows - 1) - i; j < chars.length || k <chars.length;
                     j +=2*(numRows-1), k += 2*(numRows-1)){
                    if (j < chars.length){
                        sb.append(chars[j]);
                    }
                    if (k < chars.length){
                        sb.append(chars[k]);
                    }
                }
            }

        }
        return sb.toString();
    }
}
