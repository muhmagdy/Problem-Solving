import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public int numSimilarGroups(String[] strs) {
        List<Set<String>> groups = new LinkedList<>();
        int nGroups = 0;
        for(String s: strs){
            boolean isAdded = false;
            int groupIndex = -1;
            List<Integer> toBeRemoved = new ArrayList<Integer>();
            for(int i = 0; i < groups.size(); i++){
                Set<String> group = groups.get(i);
                Iterator<String> iterator = group.iterator();
                while(iterator.hasNext()){
                    String groupString = iterator.next();
                    if(isSimilar(s, groupString)){
                        if(!isAdded){
                            isAdded = true;
                            groupIndex = i;
                            break;
                        }else{
                            groups.get(groupIndex).addAll(group);
                            toBeRemoved.add(i);
                            // groups.remove(i);
                            nGroups--;
                        }
                    }
                }
            }
            if(!isAdded){
                Set<String> newGroup = new HashSet<>();
                newGroup.add(s);
                groups.add(newGroup);
                nGroups++;
            }else{
                groups.get(groupIndex).add(s);
                for(int i = 0; i < toBeRemoved.size(); i++){
                    groups.remove(toBeRemoved.get(i) - i);
                }
            }
        }
        return nGroups;
    }

    private boolean isSimilar(String str1, String str2){
        Character char1 = null, char2 = null;
        int diff = 0;
        for(int i = 0; i < str1.length(); i++){
            char c1 = str1.charAt(i), c2 = str2.charAt(i);
            if(str1.charAt(i) != str2.charAt(i)){
                if(char1 == null && char2 == null){
                    char1 = c1;
                    char2 = c2;
                    diff++;
                }
                else if(char1 != c2 || char2 != c1)
                    return false;
                else
                    diff++;
            }
        }
        return diff == 2 || diff == 0;
    }
}