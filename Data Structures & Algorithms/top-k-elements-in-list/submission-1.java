class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (map.get(a)-map.get(b)));
        
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int numb :map.keySet()){
            pq.add(numb);

            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int i = 0; i<k;i++){
            result[i]=pq.poll();
        }
        return result;

    }
}
