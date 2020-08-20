package RePractice.NewPractice_7022;

import java.util.Random;

public class Code_Math_0819_470 {
    public int rand10() {
        int index = Integer.MAX_VALUE;
        //index这里还没有 + 1 因此是39 而不是 40
        while (index > 39){
            index = (rand7() - 1) * 7 + rand7() - 1;
        }
        return index % 10 + 1;
    }

    public int rand7() {
        int index = Integer.MAX_VALUE;
        //index这里还没有 + 1 因此是39 而不是 40
        while (index > 20){
            index = (rand5() - 1) * 7 + rand5() - 1;
        }
        return index % 7 + 1;
    }
}
