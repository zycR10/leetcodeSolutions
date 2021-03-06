# IntersectionTwoLinkedLists

## 题目
编写一个程序，找到两个相交链表的相交部分的起始节点
例如链表A：a->b->c->d->e
链表B：x->y->z->c->d->e
两个链表的以c->d->e部分相交，返回起始节点c
 
## 思路 
首先链表题就要向指针的方向去想，因为指针可以很方便的操作位置移动，这道题让我们找到链表的交点，所以大概设想一下，如果我们有两个指针去移动，
在某种条件下可以保证两个指针同时移动到交点即可，再分析一下两个链表，由于两个链表长度未知，所以我们并不好写出这样的条件，那要怎么才能保证
两个指针同时走到交点呢？其实这里可以用合二为一的想法去思考，因为单个链表长度未知，所以我们也无法确定如何找到交点，但是如果有交点，那么两个
链表其实是存在某种关系的，或者说这道题和之前做过的一道链表有环找环在链表上的交点有点儿类似，我们可以把两个链表也看出一条链表，假设a链表长度
为m，b链表长度为n，那么总长度其实一定是m+n，这个是固定的，而由于a和b之间存在重合的部分，所以总长度m+n的链表中，最后一部分一定是相同的，即
两个链表的重合部分，所以我们只需要两个指针去移动，当遍历完a链表后，我们继续转到b链表(反之另一个指针是从b到a)，这样两个指针最后一定会在交点
处相遇，或者没有交点的话就在尾指针后的null处相遇

## 实现 
```
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
```