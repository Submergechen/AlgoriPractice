package RePractice.SwordOffer;

public class Code_1223_29rorate {
    //依次转完每个圈，也是转最外面一层的圈
    public static void rorate(int[][] arr){
        int LR = 0;
        int LC = 0;
        int RR = arr.length - 1;
        int RC = arr[0].length - 1;
        while (LR < RR){
            rotateEdge(arr , LR ,LC, RR, RC);
        }
    }

    public static void rotateEdge(int[][] arr ,int LR ,int LC ,int RR, int RC){
        int times = RC - LC;
        int temp = 0;
        for (int i = 0; i != times; i++){
            //第一个
            temp = arr[LR][LC+i];

            arr[LR][LC+i] = arr[RR - i][LC];
            arr[RR - i][LC] = arr[RR][RC - i];
            arr[RR][RC - i] = arr[LR + i][RC];
            arr[LR + i][RC] = temp;
        }
    }
}
