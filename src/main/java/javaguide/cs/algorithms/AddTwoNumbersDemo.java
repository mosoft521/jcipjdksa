package javaguide.cs.algorithms;

/**
 * LeetCode 2 https://leetcode-cn.com/problems/add-two-numbers/description/
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 */
public class AddTwoNumbersDemo {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = listNode1, q = listNode2, curr = dummyHead;
        //carry 表示进位数
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            //进位数
            carry = sum / 10;
            //新节点的数值为sum % 10
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode tmp = new ListNode(4);
        l1.next = tmp;
        tmp = new ListNode(3);
        l1.next.next = tmp;
        ListNode l2 = new ListNode(5);
        tmp = new ListNode(6);
        l2.next = tmp;
        tmp = new ListNode(4);
        l2.next.next = tmp;
        ListNode r = addTwoNumbers(l1, l2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
/*
7
0
8
 */