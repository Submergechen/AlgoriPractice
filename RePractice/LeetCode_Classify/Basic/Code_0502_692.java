package RePractice.LeetCode_Classify.Basic;

import java.util.*;

//第八题
public class Code_0502_692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0)
            return res;

        // frequency map
        Map<String, Integer> map = new HashMap<>();
        for(String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }


        Queue<String> queue = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));

        // sort it using queue
        for(String s : map.keySet()) queue.add(s);

        // result
        while(k-->0)
            res.add(queue.poll());

        return res;
    }
}

//
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }
    //fangfa
        List<String> output = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        PriorityQueue<String> minHeap = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String left, String right ) {
                if (map.get(left) == map.get(right)) {
                    return -left.compareTo(right);
                }
                return map.get(left) < map.get(right) ? -1 : 1;
            }
        });

        // hash
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word,  map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        // heap
        String[] keys = map.keySet().toArray(new String[0]);
        for (int i = 0; i < k; i++) {
            minHeap.offer(keys[i]);
        }
        for (int i = k; i < keys.length; i++) {
            if (map.get(keys[i]) >= map.get(minHeap.peek())) {
                minHeap.offer(keys[i]);
                minHeap.poll();
            }
        }
        //output
        Deque<String> stack = new ArrayDeque<String>();
        for (int i = 0; i < k; i++) {
            stack.push(minHeap.poll());
        }
        for (int i = 0; i < k; i++) {
            output.add(stack.pop());
        }
        return output;
    }