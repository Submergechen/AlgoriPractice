package RePractice.SwordOffer;

public class Code_1223_29printZigZag {
    public static void printZig(int[][] arr ){
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = arr.length - 1;
        int endC = arr[0].length - 1;

        boolean fromUp = false;
        while (aR != endR){
            printLevel(arr ,aR,aC,bR,bC,endR,endC,fromUp);
            aR = aC == endC ? aR+1 : aR;
            aC = aC == endC ? aC: aC+1;
            bR = bR == endR ? bR : bR+1;
            bC = bR == endR ? bC+1 : bC;
        }
        System.out.println();
    }

    public static void printLevel(int[][] arr , int aR ,int aC , int bR,int bC ,int endR , int endC , boolean fromUp){
        if (fromUp){
            while (aR != bR + 1){
                System.out.println(arr[aR++][aC--] + " ");
            }
        }else {
            while (bR != aR - 1){
                System.out.println(arr[bR--][bC++]);
            }
        }
    }
}
