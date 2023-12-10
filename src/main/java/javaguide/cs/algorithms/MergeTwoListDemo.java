package javaguide.cs.algorithms;

/**
 * 剑指 offer:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337
 * 描述
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，转换过程如下图所示：
 * 或输入{-1,2,4},{1,3,4}时，合并后的链表为{-1,1,2,3,4,4}，所以对应的输出为{-1,1,2,3,4,4}，转换过程如下图所示：
 * 示例1
 * 输入：
 * {1,3,5},{2,4,6}
 * 返回值：
 * {1,2,3,4,5,6}
 * 示例2
 * 输入：
 * {},{}
 * 返回值：
 * {}
 * 示例3
 * 输入：
 * {-1,2,4},{1,3,4}
 * 返回值：
 * {-1,1,2,3,4,4}
 */
public class MergeTwoListDemo {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoList(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        a.next = b;
        b.next = c;
        ListNode a2 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode c2 = new ListNode(6);
        a2.next = b2;
        b2.next = c2;
        ListNode r = mergeTwoList(a, a2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
/*
1
2
3
4
5
6
 */