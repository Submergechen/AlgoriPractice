package RePractice.LeetCode_Classify.Binary;

public class Code_0609_875 {
    public int minEatingSpeed(int[] piles, int H) {
        int r = -1;
        for (int i = 0;i < piles.length;i++){
            r = Math.max(piles[i],r);
        }
        //出现mid = 0 的情况 报错
        //int l = 0;
        int l  = 1;
        while (l < r){
            int mid = (l + r) >> 1;
            if (check(piles,mid) <= H){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    //这个函数写de很好！！
    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += (p-1) / K + 1;
        return time <= H;
    }
    public int check(int[] piles , int mid){
        int count = 0;
        for (int i = 0; i < piles.length;i++){
            int x = piles[i] / mid;
            int y = piles[i] % mid;
            count += x;
            if (y != 0){
                count += 1;
            }
        }
        return count;
    }
}
