package RePractice.SwordOffer0316Twice;

import class_08.FaceBook;

public class Code_0411_64teminator {
    //编程语言里面， A&&B 只要A是false ，那么B是肯定不会执行的
    // 同样 A||B 只要A是true那么不管B是什么，B都不会执行
    public int getSum(int n){
        int res = n;
        //但是不让用if语句
        if (n > 0){
            res += getSum(n-1);
        }

        //所以这句改写成
        boolean flag = (n > 0)  && (res+= getSum(n - 1)) > 0;
        return res;
    }
}
