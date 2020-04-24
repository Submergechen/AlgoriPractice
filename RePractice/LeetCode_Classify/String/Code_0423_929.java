package RePractice.LeetCode_Classify.String;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code_0423_929 {
    //比较正常de思路思路！
    public int numUniqueEmails(String[] emails) {
        if (emails == null){
            return 0;
        }
        Set<String> res = new HashSet<>();
        for (String email : emails){
            //拆分！
            String[] s = email.split("@");
            //如果有+号的话？
            String[] x = s[0].split("\\+");
            char[] chars = x[0].toCharArray();
            //去除"."
            StringBuilder sb = new StringBuilder();
            for (char o : chars){
                if (o == '.'){
                    continue;
                }
                sb.append(o);
            }
            sb.append("@").append(s[1]);
            res.add(sb.toString());
        }
        return res.size();
    }

    public String getEMail(String email) {
        int index = email.indexOf("@");
        String domain = email.substring(index);
        //0 -- index - 1;
        String name = email.substring(0 , index);
        index = name.indexOf("+");
        if (index > 0){
            name = name.substring(0,index);
        }
        name = name.replaceAll("." ,"");
        return name + domain;
    }

    public int numUniqueEmails1(String[] emails) {
        Set<String> res = new HashSet<>();
        for (String x : emails){
            String o = getEMail(x);
            res.add(o);
        }
        return res.size();

    }
}
