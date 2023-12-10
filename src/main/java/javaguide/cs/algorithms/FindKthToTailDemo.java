package javaguide.cs.algorithms;

/**
 * 剑指 offer: 输入一个链表，输出该链表中倒数第 k 个结点。
 * 时间复杂度O(n),一次遍历即可
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a
 * 输入：
 * 1,{1,2,3,4,5}
 * 返回值：
 * {5}
 */
public class FindKthToTailDemo {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode findKthToTail(ListNode head, int k) {
        // 如果链表为空或者k小于等于0
        if (head == null || k <= 0) {
            return null;
        }
        // 声明两个指向头结点的节点
        ListNode node1 = head, node2 = head;
        // 记录节点的个数
        int count = 0;
        // 记录k值，后面要使用
        int index = k;
        // node1指针先跑，并且记录节点数，当node1节点跑了k-1个节点后，node2节点开始跑，
        // 当node1节点跑到最后时，node2节点所指的节点就是倒数第k个节点
        while (node1 != null) {
            node1 = node1.next;
            count++;
            if (k < 1) {
                node2 = node2.next;
            }
            k--;
        }
        // 如果节点个数小于所求的倒数第k个节点，则返回空
        if (count < index)
            return null;
        return node2;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode r = findKthToTail(a,1);
        System.out.println(r.val);//5
    }
}