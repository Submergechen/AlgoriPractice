package RePractice.LeetCode_Classify.Bit;

public class Code_0615_338 {
    //也可以算 是动态规划把！
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 1;i <= num;i++){
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    // 普通做法
    public int[] countBits(int num) {
        if (num < 0){
            return null;
        }
        int[] res = new int[num + 1];
        for (int i = 0;i <= num; i++){
            res[i] = count1(i);
        }
        return res;
    }

    public int count1(int num){
        int count = 0;
        while (num != 0){
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }
}
