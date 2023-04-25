import java.util.HashMap;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int weight: people){
            Integer f = freq.get(weight);
            if(f == null)
                freq.put(weight, 1);
            else
                freq.put(weight, f+1);
        }
        int nBoats = 0;
        for(int weight: people){
            Integer f = freq.get(weight);
            if(f > 0){
                freq.put(weight, f-1);
                for(int i = limit-weight; i > 0; i--){
                    Integer comp = freq.get(i);
                    if(comp != null && comp > 0){
                        freq.put(i, comp-1);
                        break;   
                    }
                }
                nBoats++;
            }
        }
        return nBoats;
    }
}