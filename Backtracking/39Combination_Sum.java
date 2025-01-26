/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.*/

// the runtime for this algorithm is O(2^n)

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtracking(candidates, target, 0, new LinkedList<>());
        return res;
    }

    private void backtracking(int[] candidates, int remaining, int index, LinkedList<Integer> current) {
        // Base case: If the remaining target is 0, add the current combination to the result
        if (remaining == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        // Explore candidates starting from 'index'
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > remaining) continue; // Skip if the candidate is greater than the remaining target

            // Choose the current candidate
            current.add(candidates[i]);
            // Recurse with the reduced target and the same index (to allow reuse of the current candidate)
            backtracking(candidates, remaining - candidates[i], i, current);
            // Backtrack: Remove the last added candidate
            current.removeLast();
        }
    }

}