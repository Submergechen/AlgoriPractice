package RePractice.SwordOffer;

public class Code_1223_29printMatrixInCircle {
    public static void circle(int[][] arr){
        int lR = 0;
        int lC = 0;
        int RR = arr.length - 1;
        int RC = arr[0].length - 1;
        while (lR <= RR && lC <= RC){
            printEdge(arr , lR++ , lC ++, RR--,RC--);
        }
    }

    public static void printEdge(int[][] arr ,int lR, int lC , int RR ,int RC){
        if (lR == RR ){
            for (int i = lC; i <= RC; i++){
                System.out.println(arr[lR][i] + " ");
            }
        }else if (lC == RC){
            for (int i = lR ; i <= RR ; i++){
                System.out.println(arr[i][lC] + " ");
            }
        }else {
            int curC = lC;
            int curR = lR;
            while (curC != RC){
                System.out.println(arr[curR][curC] + " ");
                curC++;
            }
            while (curR != RR){
                System.out.println(arr[curR][curC] + " ");
                curR++;
            }
            while (curC != lC){
                System.out.println(arr[curR][curC] + " ");
                curC--;
            }
            while (curR != lR){
                System.out.println(arr[curR][curC] + " ");
                curR--;
            }
        }
    }
}
