import java.util.PriorityQueue;

class SmallestInfiniteSet {
    PriorityQueue<Integer> set;
    int largestPoped = 0;
    public SmallestInfiniteSet() {
        this.set = new PriorityQueue<>();
        this.set.add(1);        
    }
    
    public int popSmallest() {
        if(set.isEmpty())
            set.add(++largestPoped);
        int poped = set.poll();
        if(poped > largestPoped)
            largestPoped = poped;
        return poped;
    }
    
    public void addBack(int num) {
        if(!set.contains(num) && num <= largestPoped)
            set.add(num);
    }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */