package lintcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class I0104MergeKSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private class Less implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Less());

        for (ListNode l : lists) {
            if (l != null) pq.offer(l);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null) pq.offer(tail.next);
            tail.next = null;
        }

        return dummy.next;
    }





    public ListNode mergeKLists_(List<ListNode> lists) {
        
        lists = filterNull(lists);
        if (lists.isEmpty()) return null;

        while (lists.size() > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            Iterator<ListNode> it = lists.iterator();
            while (it.hasNext()) {
                ListNode a = it.next();
                ListNode b = it.hasNext() ? it.next() : null;
                mergedLists.add(merge(a, b));
            }
            lists = mergedLists;
        }
        return lists.get(0);
    }

    private List<ListNode> filterNull(List<ListNode> lists) {
        List<ListNode> nonEmptyList = new ArrayList<>();
        for (ListNode l : lists) {
            if (l != null) nonEmptyList.add(l);
        }
        return nonEmptyList;
    }

    private ListNode remove(ListNode dst, ListNode src) {
        dst.next = src;
        return src.next;
    }

    private ListNode advanceTail(ListNode tail) {
        tail = tail.next;
        tail.next = null;
        return tail;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (a != null && b != null) {
            if (a.val <= b.val) a = remove(tail, a);
            else b = remove(tail, b);
            tail = advanceTail(tail);
        }
        while (a != null) {
            a = remove(tail, a);
            tail = advanceTail(tail);
        }
        while (b != null) {
            b = remove(tail, b);
            tail = advanceTail(tail);
        }
        return head.next;
    }

}
