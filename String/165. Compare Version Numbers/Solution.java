class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1_splitted = version1.split("[.]");
        String[] v2_splitted = version2.split("[.]");
        int n = Math.min(v1_splitted.length, v2_splitted.length);
        for(int i = 0; i < n; i++){
            int v1 = Integer.parseInt(v1_splitted[i]);
            int v2 = Integer.parseInt(v2_splitted[i]);
            if(v1 > v2)
                return 1;
            else if(v1 < v2)
                return -1;
        }
        if(v1_splitted.length > n){
            for(int i = n; i < v1_splitted.length; i++){
                if(Integer.parseInt(v1_splitted[i]) > 0)
                    return 1;
            }
        }else if(v2_splitted.length > n){
            for(int i = n; i < v2_splitted.length; i++){
                if(Integer.parseInt(v2_splitted[i]) > 0)
                    return -1;
            }
        }
        return 0;
    }
}