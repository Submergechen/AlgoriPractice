package RePractice.SwordOffer0316Twice;

import java.util.ArrayList;
import java.util.List;

public class Code_0407_49getUglyNubmer {
    //     1      2
    //   / | \    |
    //  2  3  5   2
    // i   j  k   i
    //  min
    public int solution(int n){
        // while(--n)  n-1 次
        //while(n--)  n 次
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int i = 0 , j = 0 , k = 0;
        while ((--n) != 0){
            int t = Math.min(Math.min(res.get(i)*2 , res.get(j) * 3) , res.get(k) * 5);
            res.add(t);
            if (res.get(i) * 2 == t) i++;
            if (res.get(j) * 3 == t) j++;
            if (res.get(k) * 5 == t) k++;
        }
        return res.get(res.size() - 1);
    }
}
