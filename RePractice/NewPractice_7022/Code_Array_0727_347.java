package RePractice.NewPractice_7022;

import java.util.*;

public class Code_Array_0727_347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (int x : map.keySet()){
            priorityQueue.offer(x);
        }

        int[] res = new int[k];
        for (int i = 0;i < k;i++){
            res[i] = priorityQueue.poll();
        }
        return res;
    }
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }


       TreeMap<Integer,LinkedList> treeMap = new TreeMap<>(Comparator.reverseOrder());
    //可能重复！
        for (Integer x : map.keySet()){
            int temp = map.get(x);
            if (!treeMap.containsKey(temp)){
                treeMap.put(temp,new LinkedList<>());
            }
            treeMap.get(temp).add(x);
        }

        int[] res = new int[k];
        int i = 0;
        for (Integer x : treeMap.keySet()){
                lis = treeMap.get(x);
                if (i < k - 1){
                    i++;
                }else {
                    break;
                }
            }
        return res;


    }

    //bucket
    public List<Integer> topKFrequent2(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
