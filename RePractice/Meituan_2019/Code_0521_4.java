package RePractice.Meituan_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code_0521_4 {
    public static class Segement implements Comparable<Segement>{
        //属于行还是列 里的第几行 第几列
        int k;
        //左边界和右边界
        int l, r;

        public Segement(int k, int l, int r) {
            this.k = k;
            this.l = l;
            this.r = r;
        }
        //重写！
        @Override
        public int compareTo(Segement o) {
            if (k != o.k){
                return k - o.k;
            }
            if (l != o.l){
                return l - o.l;
            }
            return r - o.r;
        }
    }
    //对横 纵部分进行处理
    public static long merge(List<Segement> q){
        //根据左端点排序？
        Collections.sort(q);
        long res = 0;
        //
        for (int i = 0;i < q.size();){
            int j = i;
            while (j < q.size() && q.get(i).k == q.get(j).k){
                j++;
            }
            //初始为不存在
            double l = -2e9;
            double r = l - 1;
            for (int k = i; k < j;k++){
                //如果当前右端点 小于 左端点！
                if (r < q.get(k).l){
                    res += r - l + 1;
                    l = q.get(k).l;
                    r = q.get(k).r;
                }else {
                    r = Math.max(r,q.get(k).r);
                }
            }
            res += r - l + 1;
            i = j;
        }
        return res;

    }

    public static void main(String[] agrs){
        int n;
        Scanner sc = new Scanner(System.in);
         List<Segement> rows = new ArrayList<>();
         List<Segement> cols = new ArrayList<>();
        n = sc.nextInt();
        while ((n--) != 0){
            int x1,y1,x2,y2;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            if (x1 == x2){
                cols.add(new Segement(x1,Math.min(y1,y2),Math.max(y1,y2)));
            }else {
                rows.add(new Segement(y1,Math.min(x1,x2),Math.max(x1,x2)));
            }

        }

        long res = merge(rows) + merge(cols);
        //处理重复的！
        for (Segement r : rows){
            for (Segement c : cols){
                if (r.k >= c.l && r.k <= c.r && c.k >= r.l && c.k <= r.r){
                    res--;
                }
            }
        }
        System.out.println(res);
    }

}
