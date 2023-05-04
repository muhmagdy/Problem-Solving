class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Character> queue = new ArrayDeque<>();
        Deque<Character> nextQueue = new ArrayDeque<>();
        for(int i = 0; i < senate.length(); i++)
            queue.add(senate.charAt(i));
        char winner = '0';
        while(winner == '0'){
            if(queue.isEmpty()) {
                queue = nextQueue;
                nextQueue = queue;
            }
            char player = queue.remove();
            char adversary = player == 'D' ? 'R' : 'D';
            nextQueue.add(player);
            if(!queue.remove(adversary) && !nextQueue.remove(adversary))
                winner = player;
        }
        return winner == 'D' ? "Dire" : "Radiant";
    }
}