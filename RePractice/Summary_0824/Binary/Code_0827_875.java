package RePractice.Summary_0824.Binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code_0827_875 {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 0,r = 10000;
        while (l < r){
            int mid = l + r >> 1;
            if (check(piles,H,mid)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    //超时～
    public boolean check(int[] piles, int H,int mid ){
        int cnt = 0;
        for (int i = 0;i < piles.length;i++){
            int cur = piles[i];
            while (cur > 0){
                cur -= mid;
                cnt++;
            }
        }
        return cnt <= H;
    }
}
