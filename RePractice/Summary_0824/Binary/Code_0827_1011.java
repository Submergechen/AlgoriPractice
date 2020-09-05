package RePractice.Summary_0824.Binary;

public class Code_0827_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int max = 0;
        for (int weight : weights){
            sum += weight;
            max = Math.max(max,weight);
        }
        int l = max, r = sum;
        while (l < r){
            int mid = l + r >> 1;
            if (check(weights,mid,D)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] weights , int mid ,int D){
        int count = 0;
        int temp = 0;
        for (int i = 0;i < weights.length;i++){
            if (temp + weights[i] <= mid){
                temp += weights[i];
            }else {
                count++;
                temp = 0;
                temp += weights[i];
            }


        }
        count++;

        return count <= D;
    }
}
