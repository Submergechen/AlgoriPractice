package RePractice.SwordOffer0316Twice;

import java.util.*;

public class Code_0405_40getLeastKnumbers {
    //用大根堆来实现
    public List<Integer> getK(int[] arr , int k){
        //
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int x : arr){
            maxHeap.add(x);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        List<Integer> res = new ArrayList<>();

        while (maxHeap.size() != 0){
            res.add(maxHeap.poll()) ;
        }
        //怎么反向？
        Collections.reverse(res);
        return res;
    }

    //用partition来实现
    public int[] solution2(int[] arr , int k){
        if (arr == null || arr.length < k || k < 1 || k > arr.length){
            return null;
        }
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, 0 , end);
        while (index != k -1){
            if (index > k - 1){
                end = index - 1;
                index = partition(arr , start ,end);
            }else {
                start = index + 1;
                index = partition(arr , start, end);
            }

        }
        int[] res = new int[k];
        for (int i = 0; i < k ; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public int partition(int[] arr ,int left , int right){
        int less = left - 1;
        int more = right;
        int cur = left;
        while (cur < more){
            if (arr[cur] < arr[right]){
                swap(arr , ++less , cur++);
            }else if (arr[cur] > arr[right]){
                swap(arr , cur ,--more);
            }else {
                cur++;
            }
        }
        swap(arr,more,right);
        return more;
    }

    public void swap(int[] arr , int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
