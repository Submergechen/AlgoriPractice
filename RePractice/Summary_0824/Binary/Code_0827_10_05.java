package RePractice.Summary_0824.Binary;

public class Code_0827_10_05 {
    public int solution(String[] words, String s) {
        int len = words.length;
        int l = 0, r = len - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (words[mid].equals("")){
                int j = mid;
                while (j >= 0 && !words[j].equals("")){
                    j--;
                }
                if (words[j].equals(s)){
                    return j;
                }else if (words[j].compareTo(s) > 0){
                    r = j;
                }else {
                    l = j + 1;
                }
            }else if (words[mid].compareTo(s) > 0){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    public int solution1(String[] words, String s) {
        int len = words.length;
        int l = 0, r = len - 1;
        while (l < r){
            while (l < r && words[l].equals("")) l++;
            while (l < r && words[r].equals("")) r--;
            if (l < r){
                int mid = l + r >> 1;
                int j = mid;
                while (j < r && words[j].equals("")) j++;
                if (words[j].compareTo(s) > 0){
                    r = j - 1;
                }else if (words[j].compareTo(s) < 0){
                    l = j + 1;
                }else {
                    return j;
                }

            }

        }
        return -1;
    }
}
