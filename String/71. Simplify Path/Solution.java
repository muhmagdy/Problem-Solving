class Solution {
    public String simplifyPath(String path) {
        int length = path.length();
        StringBuilder simplifiedPath = new StringBuilder();
        int i = 0;
        while(i < length){
            int nextSlash = path.indexOf('/', i+1);
            nextSlash = nextSlash < 0 ? length : nextSlash;
            String currentDir = path.substring(i, nextSlash);
            i = nextSlash;
            if(currentDir.equals("/.") || currentDir.isEmpty() || currentDir.equals("/"))
                continue;
            else if (currentDir.equals("/..")){
                int lastSlash = simplifiedPath.lastIndexOf("/");
                if(lastSlash >= 0)
                    simplifiedPath.setLength(lastSlash);
            }
            else {
                simplifiedPath.append(currentDir);
            }   
        }
        if(simplifiedPath.isEmpty())
            simplifiedPath.append('/');
        return simplifiedPath.toString();
    }
}