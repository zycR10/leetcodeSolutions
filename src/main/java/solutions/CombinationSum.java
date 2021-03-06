package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @Author: Zuo Yichen
 * @Date: 2018/12/5 22:22
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0, candidates, new ArrayList<>(), res, target, 0);
        return res;
    }

    private int backTrack(int sum, int[] candidates, List<Integer> currList, List<List<Integer>> res, int target, int start) {
        if (sum > target) {
            return 1;
        }
        if (sum == target) {
            res.add(new ArrayList<>(currList));
            return 0;
        }else {
            for (int i = start; i < candidates.length; i++) {
                currList.add(candidates[i]);
                int sumResult = backTrack(sum + candidates[i], candidates, currList, res, target, i);
                currList.remove(currList.size() - 1);
                // arrays has been sorted, if sum > target or sum = target
                // means it's obviously sum + next element > target, so we can break the loop here.
                if (sumResult != -1) {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        new CombinationSum().combinationSum(candidates, 7);
    }
}
