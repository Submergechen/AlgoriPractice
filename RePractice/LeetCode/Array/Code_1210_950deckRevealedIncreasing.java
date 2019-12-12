package RePractice.LeetCode.Array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Code_1210_950deckRevealedIncreasing {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> deque = new LinkedList<Integer>();
        Arrays.sort(deck);

        int[] res = new int[deck.length];

        for (int i = deck.length - 1; i >= 0 ; i--){
            if (deque.size() < 2){
                deque.offerFirst(deck[i]);
            }else {
                deque.offerFirst(deque.pollLast());
                deque.offerFirst(deck[i]);
            }
        }
        for (int i = 0; i < deck.length ; i++){
            res[i] = deque.pollFirst();
        }
        return res;
    }
}
