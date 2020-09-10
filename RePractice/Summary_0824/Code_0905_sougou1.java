package RePractice.Summary_0824;

public class Code_0905_sougou1 {
    public int numberofprize (int a, int b, int c) {
        int l = 0;
        int r = Math.max(a,Math.max(b,c));
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (check(a,b,c,mid)){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return l;

    }

    public boolean check(int a,int b ,int c ,int mid){
        int plus = 0;
        if (a >= mid){
            plus += (a - mid);
        }
        if (b >= mid){
            plus += (b - mid);
        }
        if (c >= mid){
            plus += (c - mid);
        }
        int minus = 0;
        if (a <= mid){
            minus += (mid- a);
        }
        if (b <= mid){
            minus += (mid- b);
        }
        if (c <= mid){
            minus += (mid- c);
        }

        return plus / 2 >= minus;
    }

}
