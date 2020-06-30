package RePractice.SwordOffer0316Twice;

import java.util.Arrays;

public class Code_0411_61isContinuous {
    public boolean solution(int[] numbers){
        if (numbers == null || numbers.length < 5){
            return false;
        }
        Arrays.sort(numbers);
        int index = 0;
        while (numbers[index] == 0) {
            index++;
        }
        for (int i = index + 1; i < numbers.length ; i++){
            if (numbers[i] == numbers[i-1]){
                return false;
            }
        }
        return numbers[numbers.length - 1] - numbers[index] <= 4;
    }
}
