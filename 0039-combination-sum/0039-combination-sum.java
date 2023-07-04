import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(res, current, target, candidates, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> current, int target, int[] candidates, int startIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            current.add(candidates[i]);
            helper(res, current, target - candidates[i], candidates, i);
            current.remove(current.size() - 1);
        }
    }
}