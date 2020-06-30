package RePractice.SwordOffer0316Twice;

public class Code_0318_29Print {
    public static void print(int[][] arr){
        if (arr == null || arr.length < 1 || arr[0].length < 1){
            return;
        }
        int lr = 0, lc = 0 , rr = arr.length - 1 , rc = arr[0].length - 1;
        while (lc <= rr && lc <= rc){
            printEdge(arr,lr++,lc++,rr++,rc++);
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
