package RePractice.SwordOffer0316Twice;

/**
 * 一位数： 10个
 * 二位数： 90个 10 - 99   180 位
 * 三位数： 900个  100- 999   2700 位
 * 四位数： 9000个 1000 - 9999  36000位
 * 100 + 270 - 1  余0 就是最后一个数
 *
 * 首先确定是几位数 n- 10 - 2 * 90 - 3 * 900 .....
 * 然后确定是几位数的第几个数
 * 确定属于那个数的第几位
 *
 * 这道题里面是从0开始计算的 ，但是平时计算是从1开始计算的
 */
public class Code_0406_44digitAtIndex {
    public int solution(int n){
        if (n == 0){
            return 0;
        }
        //从0开始
        n ++;
        // 10 90 900 把第一个数改成9
        n --;
        int i = 1; //i 枚举的是位数
        //这一位有多少个数
        long s = 9;
        //这位从几开始
        int base = 1;
        while (n > i * s){
            n -= i * s;
            i++;
            s *= 10;
            base *= 10;
        }

        //第二步，需要上取整
        //int number = base + (int)Math.ceil(n / i) + 1;
        int number = base + (n + i - 1) / i - 1;
        int r = n % i  == 0 ? i : n % i;
        //如果是倒数第二位，那除10就可以了
        //比如 12561 要求第二位数字，那么直接数组的长度 - i = 3  除去后面三位就可以了！
        for (int j = 0;j < i - r; j++){
            number /= 10;
        }
        //如果是最后一位的话
        return number % 10;
    }
}
