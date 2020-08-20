package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;

public class Code_TwoPointer_0810_986 {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        List<int[]> res = new ArrayList<>();
        while(i < A.length && j < B.length ){
            //
            if(A[i][1] < B[j][0]){
                i++;
            }else if(A[i][0] > B[j][1]){
                j++;
            }else{
                int[] temp = new int[2];
                temp[0] = Math.max(A[i][0],B[j][0]);
                temp[1] = Math.min(A[i][1],B[j][1]);
                res.add(temp);
                if(A[i][1] > B[j][1]){
                    j++;
                }else{
                    i++;
                }
            }
        }
        int[][] ans = res.toArray(new int[res.size()][]);
        return ans;
    }


}
