package RePractice.SwordOffer0316Twice;

/**
 * 1。 错的很离谱res += middle - left + 1; 自己一直写成
 * res += right-  middle + 1;
 * 其实  左边比右边大的话， 那么逆序对的个数 是左边i及以后的个数都是
 * 而不是右边后面的数，因为右边后面的数是有可能比左边这个数更大的！
 */
public class Code_0407_51inversePairs {
    //归并排序de时候处理一下
    int res = 0;
    public int solution(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }
        process(nums , 0 , nums.length - 1);
        return res;
    }

    public void process(int[] arr , int start , int end){
//        while (start < end){
//            int middle = (start + end) >> 1;
//            process(arr, start,middle);
//            process(arr,middle + 1,end);
//            merge(arr , start, end ,middle);
//        }
        if (start == end) {
            return;
        }
        int middle = start + ((end - start) >> 1);
        process(arr, start,middle);
        process(arr,middle + 1,end);
        merge(arr , start, end ,middle);

    }
    public void merge(int[] arr, int start, int end , int middle){
        int left = start;
        int right = middle + 1;
        int cur = 0;
        int[] help = new int[end - start + 1];
        while (left <= middle && right <= end){
            if (arr[left] > arr[right]){
                //res += 1;
                //这里真的一直错！！
                res += middle - left + 1;
                help[cur++] = arr[right++];
            }else {
                help[cur++] = arr[left++];
            }
        }
        //我这个傻逼！！！！！！！！1
//        while (left <= middle){
//            arr[cur++] = arr[left++];
//        }
//        while (right <= end){
//            arr[cur++] = arr[right++];
//        }
//        for (int j = 0; j < arr.length ; j++){
//            //出错！！
//            //arr[left +j] = help[j];
//            arr[start+j] = help[j];
//        }
    }
}

//出错！
    //归并排序de时候处理一下
    int res = 0;
    public int solution(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }
        process(nums , 0 , nums.length - 1);
        return res;
    }

    public void mergeSort(int[] arr , int l , int r){
//        while (start < end){
//            int middle = (start + end) >> 1;
//            process(arr, start,middle);
//            process(arr,middle + 1,end);
//            merge(arr , start, end ,middle);
//        }
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l,mid);
        mergeSort(arr,mid + 1,r);
        merge(arr , l, r ,mid);



    }
    public void merge(int[] arr, int l, int r , int m){
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        int[] help = new int[r - l + 1];
        while (p1 <= m && p2 <= r){
            if (arr[p1] > arr[p2]){
                //res += 1;
                //这里真的一直错！！
                res += m - p1 + 1;
                help[i++] = arr[p2++];
            }else {
                help[i++] = arr[p1++];
            }
        }
        while (p1 <= m){
            arr[i++] = arr[p1++];
        }
        while (p2 <= r){
            arr[i++] = arr[p2++];
        }
        for (i = 0; i < arr.length ; i++){
            //出错！！
            //arr[left +j] = help[j];
            arr[l+i] = help[i];
        }
    }
//ac
class Solution {
    int res = 0;
    public int inversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    public  void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public  void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            //help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            if (arr[p1] > arr[p2]){
                //res += 1;
                //这里真的一直错！！
                res += m - p1 + 1;
                help[i++] = arr[p2++];
            }else {
                help[i++] = arr[p1++];
            }
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}





    int res = 0;
    public int inversePairs(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        mergeSort(nums , 0 , nums.length - 1);
        return res;
    }

    public void mergeSort(int[] arr , int l , int r){
//        while (start < end){
//            int middle = (start + end) >> 1;
//            process(arr, start,middle);
//            process(arr,middle + 1,end);
//            merge(arr , start, end ,middle);
//        }
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l,mid);
        mergeSort(arr,mid + 1,r);
        merge(arr , l, mid ,r);



    }
    public void merge(int[] arr, int l, int m , int r){
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        int[] help = new int[r - l + 1];
        while (p1 <= m && p2 <= r){
            if (arr[p1] > arr[p2]){
                //res += 1;
                //这里真的一直错！！
                res += m - p1 + 1;
                help[i++] = arr[p2++];
            }else {
                help[i++] = arr[p1++];
            }
        }
        while (p1 <= m){
            arr[i++] = arr[p1++];
        }
        while (p2 <= r){
            arr[i++] = arr[p2++];
        }
        for (i = 0; i < arr.length ; i++){
            //出错！！
            //arr[left +j] = help[j];
            arr[l+i] = help[i];
        }
    }
/*
归并排序; 必须是降序排序
*/
class Solution {
    public int reversePairs(int[] nums) {
        //input check; 没有这个input checko会造成栈溢出错误, left=0,right=-1....
        if(nums==null || nums.length==0)
            return 0;
        return mergeSort(nums, 0, nums.length-1);
    }

    //递归函数逻辑: 先在[left,mid]上归并排序, 再在[mid+1,right]上归并排序, 最后将[left,mid]和[mid+1,right]合并
    private int mergeSort(int[] nums, int left, int right){
        //base case
        if(left==right)
            return 0;
        int mid = left + ((right-left)>>1);
        int leftRes = mergeSort(nums, left, mid);
        int rightRes = mergeSort(nums, mid+1, right);
        int curRes = merge(nums, left, mid, right);
        return leftRes + rightRes + curRes;
    }
    // 必须是降序排序! 否则结果会出错,
    // 假如还是升序, 那么merge{4,5,6}和{1,2,3}时, p1指向4, p2指向1, 第一次循环res=1,p2++; 第二次循环res=3,p2++; 第三次循环res=6,p2++; 但实际上4能构成的逆序对只有3个
    private int merge(int[] nums, int left, int mid, int right){
        int[] help = new int[right-left+1];
        int p=0, p1=left, p2=mid+1;
        int res = 0;
        while(p1<=mid && p2<=right){
            if(nums[p1] > nums[p2]){
                res += right - p2 + 1;
                help[p++] = nums[p1++];
            }else{
                help[p++] = nums[p2++];
            }
        }
        while(p1<=mid){
            help[p++] = nums[p1++];
        }
        while(p2<=right){
            help[p++] = nums[p2++];
        }

        for(int i=0; i<help.length; i++){
            nums[i+left] = help[i];
        }
        return res;
    }
}

