package RePractice.SwordOffer0316Twice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_0403_38permutation {
    //重复数字出现的情况
    //可以用set来判断重复
    ArrayList<int[]> res = new ArrayList<int[]>();
    int[] path;
    public List<int[]> perm(int[] arr){
        path= new int[arr.length];
        Arrays.sort(arr);
        dfs(arr,0,0,0);
        return res;

    }
    //start表示当前应该从哪个位置开始枚举
    // state 存的是状态，表示哪些位置，被数占了， 用二进制来表示
    public void dfs(int[]arr ,int curIndex , int start ,int state){
        if (curIndex == arr.length) {
            res.add(path);
            return;
        }
        if (curIndex == 0 || arr[curIndex] != arr[curIndex - 1]){
            start = 0;
            //可以从0开始枚举
        }
        for (int i = start; i < arr.length ; i++){
            if (((state >> i) & 1) != 1){
                path[curIndex] = arr[curIndex];
                dfs(arr , curIndex + 1 , start + 1 , state + (1 << i));
            }
        }
    }




    //普通情况
    public void solution(String str){
        char[] chars = str.toCharArray();
        process(chars,0);
    }

    public void process(char[] chars , int index){
        if (index == chars.length - 1){
            System.out.println(chars);
            return;
        }
        for (int i = index; i < chars.length; i++){
            swap(chars,index,i);
            process(chars,index + 1);
        }
    }

    public void swap(char[] chars , int i , int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
