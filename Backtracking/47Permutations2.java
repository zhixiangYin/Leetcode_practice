/*Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order. */

//the time complexity is O(n * n!)

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
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
            // Skip if the current number is already used in this permutation
            if (used[i]) continue;

            // Skip duplicates: Only allow the first unused occurrence of a duplicate number
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

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