/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
*/

//the time complexity of this algorithm is O(C(n,k) * k)

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtracking(n, k, 1, new LinkedList<>());
        return res;
    }

    private void backtracking(int n, int k, int start, LinkedList<Integer> current) {
        // Base Case: If the current combination size is k, add it to the result
        if (current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }

        // Iterate from the current starting point to n
        for (int i = start; i <= n; i++) {
            // Add the current number to the combination
            current.add(i);

            // Recurse with the next starting number
            backtracking(n, k, i + 1, current);

            // Backtrack by removing the last added number
            current.removeLast();
        }
    }
}