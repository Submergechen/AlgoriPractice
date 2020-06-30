package RePractice.ByteDance_2019;

/**
 * 用一个数组，两个指针，一个指针去遍历，一个指针去指结果，如果满足条件，下面那个指针就回退进行删除；
 * 考察了双指针算法，上面那个指针永远是在下面指针的前面，而且上面那个指针不会覆盖掉下面指针的值，所以可以用这种方法
 */
public class Code_0414_2edit {

    //从n的平方变成n
    //主要是把删除操作复杂度从n变成1
    public void solution(char[] chars){
        //k是下指针 i是上指针，遍历所有的
        //字符串最后一个\0的ascis码值是0
        int k = 0;
        for (int i = 0;chars[i] != 0 ; i++){
            chars[k++] = chars[i];
            if (k >= 3 && chars[k-3] == chars[k-2] && chars[k-2] == chars[k-1]){
                k--;
            }
            if (k >= 4 && chars[k-4] == chars[k-3] && chars[k-2] == chars[k-1]){
                k--;
            }

        }
        chars[k] = '\0';
        System.out.println(chars);
    }
}
