class Solution {

    public String encode(List<String> strs) {
        String str="";
        for(int i=0;i<strs.size();i++){
            str=str+Integer.toString(strs.get(i).length());
            str=str+",";
        }
        str=str+"#";
        for(int i=0;i<strs.size();i++){
            str=str+strs.get(i);
        }
        return str;

    }

    public List<String> decode(String str) {
        ArrayList<String> ll = new ArrayList<>();
        ArrayList<Integer> size=new ArrayList<>();
        int i=0;
        while(str.charAt(i)!='#'){
            String cur="";
            while(str.charAt(i)!=','){
                cur=cur+str.charAt(i);
                i++;
            }
            size.add(Integer.parseInt(cur));
            i++;
        }
        i++;
        for(int sz:size){
            ll.add(str.substring(i,i+sz));
            i+=sz;
        }
        return ll;
        

    }
}
