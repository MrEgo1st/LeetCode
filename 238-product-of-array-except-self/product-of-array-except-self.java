class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []finalArr = new int [nums.length];
        
        finalArr[0] = 1;
        for(int i=1; i<nums.length; i++){
            finalArr[i] = finalArr[i-1]*nums[i-1];
        }

        int productSum=1;
        for(int i=nums.length-2; i>=0; i--){
            productSum *= nums[i+1];
            finalArr[i] = finalArr[i]*productSum;
        }


        return finalArr;
    }
}
  

