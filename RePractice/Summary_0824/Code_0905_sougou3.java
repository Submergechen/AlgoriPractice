package RePractice.Summary_0824;

import java.util.HashSet;
import java.util.Set;

public class Code_0905_sougou3 {
    long res = 0;
    Set<String> set = new HashSet<>();
    public long getPasswordCount (String password) {
        if (password.equals("")){
            return 0;
        }
        // write code here

        for (int i = 0;i <= 9;i++){
            helper(password,1,new StringBuilder("i"));
        }
        return res;
    }

    public void helper(String password,int index,StringBuilder temp){
        if (index == password.length() ){
            if (!(temp.toString()).equals(password) || !set.contains(temp.toString())){
                set.add(temp.toString());
                res++;
            }
            return;
        }
        helper(password,index + 1 ,
                temp.append((char)((password.charAt(index) + temp.charAt(temp.length() - 1)  / 2) )));
        temp.deleteCharAt(temp.length() - 1);
        helper(password,index + 1 ,
                temp.append((char) ((password.charAt(index) + temp.charAt(temp.length() - 1) + 1) / 2)));
        temp.deleteCharAt(temp.length() - 1);

    }
}
