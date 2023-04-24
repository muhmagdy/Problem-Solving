class Solution {
    public boolean backspaceCompare(String s, String t) {
        return strippedString(s).equals(strippedString(t));
    }

    private String strippedString(String s){
        StringBuilder builder = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                int length = builder.length();
                if(length > 0)
                    builder.setLength(length-1);
                continue;
            }
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}