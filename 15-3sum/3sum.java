class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int currIndx = 0; currIndx < nums.length - 2; currIndx++) {
            if (currIndx > 0 && nums[currIndx] == nums[currIndx - 1]) {
                continue;
            }

            int left = currIndx + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[currIndx] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[currIndx], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}