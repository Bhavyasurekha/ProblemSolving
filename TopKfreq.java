class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length+1];
        for(int i=0;i<freq.length;i++){
            freq[i]=new ArrayList<>();
        }
        HashMap<Integer,Integer> mp= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i])+1);
            }else{
                mp.put(nums[i],1);
            }
        }
        for(Integer i:mp.keySet()){
            freq[mp.get(i)].add(i);
        }
        int arr[] = new int[k];
        int index=0;
        for(int i=freq.length-1;i>0 && index<k;i--){
            for(int n:freq[i]){
                arr[index++]=n;
                if(index==k){
                    return arr;
                }

            }
        }
        return arr;
    }
}
