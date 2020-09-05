package RePractice.Summary_0824;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code_0826_22 {
    List<String> res = new ArrayList<>();
    public List<String>  isValid(int n ){
        if (n == 0){
            return new ArrayList<String>();
        }
        dfs("",n,n);
        return res;
    }

    public void dfs(String temp ,int left , int right){
        if (left > right){
            return;
        }
        if (left == 0 && right == 0){
            res.add(temp);
            return;
        }
        if (left > 0){
            dfs(temp + "(",left - 1,right);
        }
        if (right > 0){
            dfs(temp + ")",left,right - 1);
        }
    }
}
