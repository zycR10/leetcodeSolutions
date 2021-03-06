package solutions;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * @Author: Zuo Yichen
 * @Date: 2019/11/10 23:34
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] array = new int[triangle.size()];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            //dp
            for (int j = 0; j < triangle.get(i).size(); j++) {
                array[j] = Math.min(array[j], array[j + 1]) + triangle.get(i).get(j);
            }
        }
        return array[0];
    }
}
