// https://leetcode.com/problems/copy-list-with-random-pointer/


public class Solution {
	

	public RandomListNode copyRandomList (RandomListNode head) {
		if (head == null) return null;
		Map<RandomListNode, RandomListNode> clone = new HashMap<>();
		RandomListNode curr = head;
		while (curr != null) {
			clone.put(curr, new RandomListNode(curr.label));
			curr = curr.next;
		}
		for (Map.Entry<RandomListNode, RandomListNode> pair : clone.entrySet()) {
			RandomListNode original = pair.getKey();
			RandomListNode copy     = pair.getValue();
			copy.next   = clone.get(original.next);
			copy.random = clone.get(original.random);
		}
		return clone.get(head);
	}	


}

