package RePractice.LeetCode_Classify.Dfs;

import java.util.ArrayList;
import java.util.List;
//1题
public class Code_0424_1_17 {
    //循环来处理搜索问题！
    String[] chars = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        //state
        List<String> states = new ArrayList<String>(){{
            this.add("");
        }};
        char[] chars1 = digits.toCharArray();//"2","3"
        for (char x : chars1){
            List<String> cur = new ArrayList<>();
            char[] chars2 = chars[x - '2'].toCharArray();// a b c
            for (char o : chars2){
                for (String state: states){
                     cur.add(state + o) ;
                     System.out.println(cur);
                }
            }
            states = cur;
        }
        return states;
    }
    //递归的方法，传递一个index！
    class Solution {
        private String[] chars = new String[]{"", "abc", "def", "ghi" ,"jkl", "mno", "pqrs", "tuv", "wxyz"};
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return new ArrayList();
            List<String> res = new ArrayList();
            backtrack(res, digits, new StringBuilder(), 0);
            return res;
        }
        public void backtrack(List<String> res, String digits, StringBuilder sb, int pos) {
            if (pos == digits.length() && sb.length() == digits.length()) res.add(sb.toString());
            for (int i = pos; i < digits.length(); ++i) {
                int num = digits.charAt(i) - '1';
                for (char c : chars[num].toCharArray()) {
                    sb.append(c);
                    backtrack(res, digits, sb, i + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
