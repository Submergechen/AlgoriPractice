package RePractice.Summary_0824.String;

import java.util.*;

public class Code_0901_1233 {
    public List<String> removeSubfolders(String[] folder) {
        if (folder.length < 1){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        res.add(folder[0]);
        for (int i = 1;i < folder.length;i++){
            String father = res.get(res.size() - 1);
            if (folder[i].indexOf(father + '/') == -1){
                res.add(folder[i]);
            }
        }
        return res;


    }
    public List<String> removeSubfolders1(String[] folder) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (String str : folder){
            set.add(str);
        }
        for (String str : folder){
            boolean isValid = true;
            for (int i = str.length() - 1;i > 1;i--){
                if (str.charAt(i) == '/'){
                    String temp = str.substring(0,i);
                    if (set.contains(temp)){
                        isValid = false;
                    }
                }
            }
            if (isValid){
                res.add(str);
            }
        }
        return res;
    }
}
