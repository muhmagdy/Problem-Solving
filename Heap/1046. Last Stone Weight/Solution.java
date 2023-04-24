import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for(int stone: stones)
            heap.add(stone);
        while(heap.size() > 1){
            int x = heap.poll();
            int y = heap.poll();
            if(x > y)
                heap.add(x-y);
            else if(x < y)
                heap.add(y-x);
        }
        Integer res = heap.pop();
        return res == null ? 0 : res;
    }
}