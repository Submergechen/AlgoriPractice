package RePractice.Pinduoduo2019;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Code_0521_2 {
    public static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

//        @Override
//        public int compareTo(Pair o) {
//            return this.first - o.first;
//        }
    }

    public static void main(String[] agrs){
        int n, d;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        //还能这么写！
        Pair[] banks = new Pair[n];
        for (int i = 0;i < n;i++){
//            banks[i].first = sc.nextInt();
//            banks[i].second = sc.nextInt();
            banks[i] = new Pair(sc.nextInt(),sc.nextInt());
        }
        //[] 类型的用arryas。sort
        Arrays.sort(banks, Comparator.comparing(Pair -> Pair.first));
        int res = 0;
        for (int i = 0,j = -1,maxv = 0;i < banks.length;i++){
            while (j + 1 < i && Math.abs(banks[i].first - banks[j+1].first) >= d){
                j++;
                maxv = Math.max(maxv,banks[j].second);
            }
            res = Math.max(res,maxv + banks[i].second);
        }
        System.out.println(res);

    }
}
