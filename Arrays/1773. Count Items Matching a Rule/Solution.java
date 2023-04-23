import java.util.List;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int rule = 0;
        switch(ruleKey){
            case "type":
                rule = 0;
                break;
            case "color":
                rule = 1;
                break;
            case "name":
                rule = 2;
                break;
        }

        int n = 0;

        for(List<String> item: items){
            if(item.get(rule).equals(ruleValue))
                n++;
        }

        return n;
    }
}