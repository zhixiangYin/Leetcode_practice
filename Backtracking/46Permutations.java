/* 
Given an array nums of distinct integers, return all the possible 
permutations
. You can return the answer in any order.

  */
//the time complexity of this algorithm is O(n* n!)

 class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtracking(nums, new LinkedList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtracking(int[] nums, LinkedList<Integer> current, boolean[] used) {
        // Base Case: If the current list size equals nums.length, we've found a permutation
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        // Iterate over all numbers in nums
        for (int i = 0; i < nums.length; i++) {
            // Skip numbers that are already used in the current permutation
            if (used[i]) continue;

            // Choose the current number
            current.add(nums[i]);
            used[i] = true;

            // Explore further permutations
            backtracking(nums, current, used);

            // Backtrack: Unchoose the current number
            current.removeLast();
            used[i] = false;
        }
    }
}