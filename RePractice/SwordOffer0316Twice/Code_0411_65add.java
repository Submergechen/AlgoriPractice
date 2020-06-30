package RePractice.SwordOffer0316Twice;

/**
 * 计算机里面是怎么做加法的
 * 如果是负数的情况，会不会有影响呢
 *  其实是没有影响的，因为计算机里面算正数还是负数相加，算的都是正数相加
 *      得益于补码，补码表示负数，只要支持加法 就支持减法，减去一个数， 其实就是加上一个数的补码
 * % | ～ 三种运算
 * A + B = CD
 * A  0  0  1 1
 * B  0  1  0 1
 * C  0  0  0 1
 * D  0  1  1 0
 * 所以 D = A ^ B  只有AB不同时为1
 * C = A & B  只有AB同时为1 时才是1
 * u多位数的情况，先算不进位的，再算进位的数
 * A ^ B  + (A & B) >> 1
 * A ^ B 不进位的情况
 * A & B 进位的情况，并且要左移一位
 */
public class Code_0411_65add {
    public int add(int num1, int num2){
        while (num2 != 0){
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
