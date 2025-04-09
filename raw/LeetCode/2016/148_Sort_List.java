// https://leetcode.com/problems/sort-list/


public class Solution {
	

	public ListNode sortList (ListNode head) {
				
		ListNode tape1 = new ListNode(0);
		tape1.next = head;
		ListNode tape2 = new ListNode(0);
		ListNode tape3 = new ListNode(0);
		
		int length = getLength(head);
		
		for (int i = 1; i < length; i += i) {
			split(tape1, tape2, tape3, i);
			merge(tape1, tape2, tape3, i);
		}
		
		return tape1.next;
	}	
	
	private int getLength(ListNode head) {
		int ans = 0;
		while (head != null) {
			ans += 1;
			head = head.next;
		}
		return ans;
	}
	
	private void split (ListNode tape1, ListNode tape2, ListNode tape3, int n) {
		ListNode curr = tape1.next;
		ListNode tail2 = tape2;
		ListNode tail3 = tape3;
		while (curr != null) {
			int count = 0;
			while (curr != null && count < n) {
				tail2.next = curr;
				tail2 = tail2.next;
				curr = curr.next;
				count += 1;
			}
			count = 0;
			while (curr != null && count < n) {
				tail3.next = curr;
				tail3 = tail3.next;
				curr = curr.next;
				count += 1;				
			}
		}
		tail2.next = null;
		tail3.next = null;
	}
	
	private void merge (ListNode tape1, ListNode tape2, ListNode tape3, int n) {
		ListNode tail1 = tape1;
		ListNode curr2 = tape2.next;
		ListNode curr3 = tape3.next;
		while (curr2 != null && curr3 != null) {
			int count2 = 0;
			int count3 = 0;
			while (count2 != n && count3 != n && curr2 != null && curr3 != null) {
				if (curr2.val <= curr3.val) {
					tail1.next = curr2;
					tail1 = tail1.next;
					curr2 = curr2.next;
					count2 += 1;
				}
				else {
					tail1.next = curr3;
					tail1 = tail1.next;
					curr3 = curr3.next;
					count3 += 1;
				}
			}
			while (count2 != n && curr2 != null) {
				tail1.next = curr2;
				tail1 = tail1.next;
				curr2 = curr2.next;
				count2 += 1;
			}
			while (count3 != n && curr3 != null) {
				tail1.next = curr3;
				tail1 = tail1.next;
				curr3 = curr3.next;
				count3 += 1;
			}
		}
		
		if (curr2 != null)
			tail1.next = curr2;
		else
			tail1.next = curr3;
	}


}

