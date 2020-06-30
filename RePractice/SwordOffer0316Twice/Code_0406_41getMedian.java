package RePractice.SwordOffer0316Twice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_0406_41getMedian {
    public double solution(int num){
        if (num == 0){
            throw new RuntimeException("error!");
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //题目意思理解错了！！
//        public void insert(Integer num) {
//            maxHeap.add(num);
//            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
//                int maxV = maxHeap.poll();
//                int minV = minHeap.poll();
//                maxHeap.add(minV);
//                minHeap.add(maxV);
//            }
//            while (maxHeap.size() > minHeap.size() + 1){
//                int temp = maxHeap.poll();
//                minHeap.add(temp);
//            }
//        }
        maxHeap.add(num);
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            int maxV = maxHeap.peek();
            int minV = minHeap.peek();
            maxHeap.poll();
            minHeap.poll();
            maxHeap.add(minV);
            minHeap.add(maxV);
        }
        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.peek());
            maxHeap.poll();
        }

        int flag = 1;
        if (flag == 1){
            if (!minHeap.isEmpty() && num > minHeap.peek()){
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
                flag = 1 - flag;
            }

        }else {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()){
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
                flag = 1 - flag;
            }
        }
//        int i;
//        for (i = 0 ; i < arr.length ; i++){
//            //even偶数情况， 放入minheap  但是先放入maxheap 然后弹出来
//            if (i % 2 == 0){
//                maxHeap.add(arr[i]);
//                minHeap.add(maxHeap.poll());
//            }else {
//                //odd奇数情况， 放入maxheap  但是先放入minheap 然后弹出来
//                minHeap.add(arr[i]);
//                maxHeap.add(minHeap.poll());
//            }
//        }
        if ((maxHeap.size() + minHeap .size()) % 2 == 0){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }else {
            return maxHeap.peek() * 1.0;
        }
//        return (maxHeap.peek() + maxHeap.peek()) / 2;

    }
}



