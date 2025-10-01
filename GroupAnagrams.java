class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,List<String>> hm = new HashMap<>();
       for(String s:strs){
        char[] carr=s.toCharArray();
        Arrays.sort(carr);
        String sorted=new String(carr);
        hm.putIfAbsent(sorted,new ArrayList<>());
        hm.get(sorted).add(s);
       }
       return new ArrayList<>(hm.values());

    }
}
