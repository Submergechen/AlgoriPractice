package RePractice.SwordOffer0316Twice;

public class Code_0401_29printMatrix {
    public void solution(int[][] arr){
        int rows = arr.length - 1;
        int cols = arr[0].length - 1;// 3
        int lR = 0 , lC = 0;
        int rR = rows , rC = cols;
        while (lR <= rR && lC <= rC){
            printEdge(arr , lR++ ,lC++ ,rR-- ,rC--);
        }
    }

    public void printEdge(int[][] arr , int lR , int lC ,int rR ,int rC ){
        //
        if (lR == rR){
            for (int i = lC; i <= rC ; i++){
                System.out.println(arr[lR][i] + " ");
            }

        }else if (lC == rC){
            for (int i = lR; i <= rR ; i++){
                System.out.println(arr[i][lC] + " ");
            }
        }
        int curR = lR;
        int curC = lC;
        while (curC < rC){
            System.out.println(arr[curR][curC++] + " ");
        }
        while (curR < rR){
            System.out.println(arr[curR++][curC] + " ");
        }
        while (curC > lC){
            System.out.println(arr[curR][curC--] + " ");
        }
        while (curR > lR){
            System.out.println(arr[curR--][curC] + " " );
        }


    }
}
