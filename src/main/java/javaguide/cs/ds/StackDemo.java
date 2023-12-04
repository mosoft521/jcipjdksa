package javaguide.cs.ds;

import java.util.HashMap;
import java.util.Stack;

/**
 * Leetcode 的一道题目
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断该字符串是否有效。
 * 有效字符串需满足：
 * undefined.左括号必须用相同类型的右括号闭合。
 * undefined.左括号必须以正确的顺序闭合。
 * 比如 "()"、"()[]{}"、"{[]}" 都是有效字符串，而 "(]"、"([)]" 则不是。
 */
public class StackDemo {
    public static boolean isValid(String s) {
        // 括号之间的对应规则
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (mappings.containsKey(chars[i])) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(chars[i])) {
                    return false;
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
        s = "()[]{}";
        System.out.println(isValid(s));
        s = "{[]}";
        System.out.println(isValid(s));
        s = "(]";
        System.out.println(isValid(s));
        s = "([)]";
        System.out.println(isValid(s));
    }
}
/*
true
true
true
false
false
 */