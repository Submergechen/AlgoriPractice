package RePractice.Summary_0824.DFS;

import java.util.ArrayList;
import java.util.List;

public class Code_0830_93 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        List<String> segement = new ArrayList<>();
        dfs(s,0,segement);
        return res;

    }


    public void dfs(String s ,int start , List<String> segement){
        if (start == s.length()){
            if (segement.size() == 4){
                StringBuilder sb = new StringBuilder();
                for (int i = 0;i < segement.size();i++){
                    sb.append(segement.get(i));
                    if (i != segement.size() - 1){
                        sb.append('.');
                    }
                }
                res.add(sb.toString());
            }
            return;
        }else {
            if (segement.size() >= 4){
                return;
            }
            for (int i = start;i < s.length() && i < start + 3;i++){
                String str = s.substring(start,i + 1);
                if (str.charAt(0) == '0' && str.length() > 1){
                    break;
                }
                int num = Integer.parseInt(str);
                if (num >= 0 && num <= 255){
                    segement.add(str);
                    dfs(s,i + 1,segement);
                    segement.remove(segement.size() - 1);
                }else {
                    break;
                }
            }
        }
    }
}
