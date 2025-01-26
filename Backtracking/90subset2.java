/*
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
*/

//the time complexity of this algorithm is O(2^n)


class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to group duplicates together
        backtracking(nums, 0, new LinkedList<>());
        return res;
    }

    private void backtracking(int[] nums, int index, LinkedList<Integer> current) {
        // Add the current subset to the result list
        res.add(new ArrayList<>(current));

        // Explore further subsets
        for (int i = index; i < nums.length; i++) {
            // Skip duplicate elements to avoid duplicate subsets
            if (i > index && nums[i] == nums[i - 1]) continue;

            // Choose the current element
            current.add(nums[i]);

            // Recurse with the next index
            backtracking(nums, i + 1, current);

            // Backtrack: Remove the last added element
            current.removeLast();
        }
    }
}