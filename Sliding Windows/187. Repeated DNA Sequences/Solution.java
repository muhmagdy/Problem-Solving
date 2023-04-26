import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length()-9; i++){
            String seq = s.substring(i, i+10);
            Integer n = freq.get(seq);
            if(n == null)
                freq.put(seq, 1);
            else
                freq.put(seq, n+1);
        }

        List<String> repeatedSequences = new LinkedList<>();
        for(Map.Entry<String, Integer> entry: freq.entrySet()){
            if(entry.getValue() > 1)
                repeatedSequences.add(entry.getKey());
        }

        return repeatedSequences;
    }
}