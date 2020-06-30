package RePractice.JD2019;

import java.util.Scanner;

public class Code_0414_2buchong {
    static int M = 10010 , N = 210;
    int n;
    int[] a = new int[N];
    int[][][] f = new int[N][M][3];
    //0 1 前缀和
    int[] s1 = new int[N];
    //0 1 2 前缀和
    int[] s2 = new int[N];

}

public class Gone {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long mod=998244353;
        int n = sc.nextInt();
        int[] arr=new int[n+10];
        for (int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }
        long[][][] f=new long[n+10][210][3];
        long[] s2=new long[210];
        long[] s1=new long[210];
        //dp初始化 ，暴力枚举前两个数的结果
        for (int i=(arr[1]==0?1:arr[1]);i<=(arr[1]==0?200:arr[1]);i++){
            for(int j=(arr[2]==0?1:arr[2]);j<=(arr[2]==0?200:arr[2]);j++){
                if(i==j) f[2][j][1]++;
                else if(i<j) f[2][j][2]++;
            }
        }
        //前缀和
        for(int j=1;j<= 200;j++){
            s2[j]=s2[j-1]+f[2][j][0]+f[2][j][1]+f[2][j][2];
            s1[j]=s1[j-1]+f[2][j][0]+f[2][j][1];
        }
        //更新结构
        for(int i=3;i <= n;i++){
            for(int j=(arr[i]==0?1:arr[i]);j<=(arr[i]==0?200:arr[i]);j++){
                f[i][j][0]=(s1[200]-s1[j])%mod;
                f[i][j][1]=(f[i-1][j][0]+f[i-1][j][1]+f[i-1][j][2])%mod;
                f[i][j][2]=s2[j-1]%mod;
            }
            for (int j=1;j<=200;j++){
                s2[j]=s2[j-1]+f[i][j][0]+f[i][j][1]+f[i][j][2];
                s1[j]=s1[j-1]+f[i][j][0]+f[i][j][1];
            }
        }
        long res=0;
        for (int j=(arr[n]==0?1:arr[n]);j<=(arr[n]==0?200:arr[n]);j++){
            res=(res+f[n][j][0]+f[n][j][1])%mod;
        }
        System.out.println(res);
    }
}

