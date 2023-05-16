class Solution {
    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        char[] array = new char[n];
        for(int i = 0; i < n; i++)
            array[indices[i]] = s.charAt(i);
        return String.valueOf(array);
    }
}