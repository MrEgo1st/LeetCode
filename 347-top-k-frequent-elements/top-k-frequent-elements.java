class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k>nums.length) return new int[]{0};

        int []returnResult = new int[k];

        HashMap<Integer, Integer> map = new HashMap();
        for(int n: nums){
            if(!map.containsKey(n)){
                map.put(n,0);
            }
            int value = map.get(n);
            map.put(n,value+1);
        }

        ArrayList<Integer> [] freqArray = new ArrayList[nums.length+1];

        Iterator itr = map.entrySet().iterator();

        for(Map.Entry<Integer, Integer> mapElement: map.entrySet()){
            int valueKey = mapElement.getKey();
            int value = mapElement.getValue();
            if(freqArray[value] == null){
                freqArray[value] = new ArrayList<>();
            }
            freqArray[value].add(valueKey);
        }

        int index=0;
        for(int i=freqArray.length-1; i>0 && index<k; i--){
            if(freqArray[i] != null){
              
                for(Integer j: freqArray[i]){
                    returnResult[index] = j;
                    index++;
                }

                // for(int j=freqArray.size()-1; j>0; j--){
                //     returnResult[index] = i;
                //     index++;
                // }
                
            }
        }

        return returnResult;
        
    }
}