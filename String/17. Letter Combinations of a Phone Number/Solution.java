import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<String> letterCombinations(String digits) {
        int nDigits = digits.length();
        List<String> combinations = new ArrayList<>(3 << nDigits);
        String[][] letters = new String[][]{
            {"a","b","c"}, 
            {"d","e","f"}, 
            {"g","h","i"}, 
            {"j","k","l"}, 
            {"m","n","o"},  
            {"p","q","r","s"},  
            {"t","u","v"},  
            {"w","x","y","z"}, };
        for(char digit: digits.toCharArray()){
            int j = digit-50;
            if(combinations.isEmpty()){
                for(String letter: letters[j]){
                    combinations.add(letter);
                }       
            }
            else{
                List<String> newCombinations = new ArrayList<>(combinations.size()*2);
                for(String combination: combinations){
                    for(String letter: letters[j]){
                        newCombinations.add(combination.concat(letter));
                    }
                }
                combinations = newCombinations;
            }
        }

        return combinations;
    }
}