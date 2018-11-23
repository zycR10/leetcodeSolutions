package org.leetcode.solutions;

import java.util.Stack;

public class LongestValidParentheses {
    private int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        // for npe
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // stack record the index of '('
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}