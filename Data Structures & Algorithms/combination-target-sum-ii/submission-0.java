class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        helper(0, 0, new ArrayList<>(), candidates, target, ans);

        return ans;
    }

    private void helper(int i, int curSum, List<Integer> subset,
                        int[] candidates, int target,
                        List<List<Integer>> ans) {

        if (curSum == target) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        if (curSum > target || i >= candidates.length) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {

            // Skip duplicate choices at the same level
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }

            // Since sorted, no point continuing
            if (curSum + candidates[j] > target) {
                break;
            }

            subset.add(candidates[j]);

            // j + 1 because each number can be used only once
            helper(j + 1, curSum + candidates[j],
                   subset, candidates, target, ans);

            subset.remove(subset.size() - 1);
        }
    }
}