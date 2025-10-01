class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] c = s.toCharArray();
        char[] k=  t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(k);
        for(int i=0;i<c.length;i++){
            if(c[i]!=k[i]){
                return false;
            }
        }
        return true;

    }
}
