class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer , Integer > map1 = new HashMap<>();
       for(int i = 0; i<nums.length; i++){
        int diff = target - nums[i];
        if(map1.containsKey(diff)){
            return new int[]{map1.get(diff),i};
        }
        map1.put(nums[i],i);
       }
       
       return new int[]{};
    }
    
}
