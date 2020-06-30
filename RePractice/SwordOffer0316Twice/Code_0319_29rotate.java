package RePractice.SwordOffer0316Twice;

public class Code_0319_29rotate {
    public static void solution(int[][] arr){
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = arr.length - 1;
        int endC = arr[0].length - 1;
        boolean fromUp = false;

        while (aR != endR + 1){
            printLevel(arr,aR,aC,bR,bC,fromUp);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bR = bR == endR ? bR : bR +1;
            bC = bR == endR ? bC + 1 : bC;
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] arr , int aR , int aC ,int bR ,int bC ,boolean fromUp ){
        if (fromUp){
            //
            while (aR != bR + 1){
                System.out.println(arr[aR++][aC--] + " ");
            }
        }else {
            //左下到右上
            while (bR != aR - 1){
                System.out.println(arr[bR--][bC++] + " ");
            }
        }
    }
}
