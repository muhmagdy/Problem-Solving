class Solution {
    public String removeStars(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                builder.setLength(builder.length()-1);
                continue;
            }
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}