package RePractice.SwordOffer;
//待测试
public class Code_1216_4Find {
    public static boolean find(int[][] arr ,int aim){
        int row = arr.length;
        int col = arr[0].length;

        int i = 0;
        int j = col - 1;
        while (arr[i][j] != aim){
            if (arr[i][j] > aim){
                j--;
            }else {
                i++;
            }
        }
        //感觉写的不够好
        if (j < 0 || i == arr.length){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean res1 = find(A,7);
        boolean res2 = find(A, 5);
        System.out.println(res1);
        System.out.println(res2);
    }
}
