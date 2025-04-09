// https://leetcode.com/problems/flatten-nested-list-iterator/


public class NestedIterator implements Iterator<Integer> {


	Deque<Iterator<NestedInteger>> stack;
	Integer lookAhead;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new ArrayDeque<>();
		lookAhead = null;
		stack.offerLast(nestedList.iterator());
		hasNext();
	}

	@Override
	public Integer next() {
		int ans = lookAhead;
		lookAhead = null;  // already used, poll next
		hasNext();
		return ans;
	}

	@Override
	public boolean hasNext() {
		if (lookAhead != null) return true;
		while (!stack.isEmpty()) {
			if (stack.peekLast().hasNext()) {
				NestedInteger v = stack.peekLast().next();
				if (v.isInteger()) {
					lookAhead = v.getInteger();  // set lookAhead by the way
					return true;
				}
				else
					stack.offerLast(v.getList().iterator());
			}
			else {
				stack.pollLast();
			}
		}
		return false;  // exhausted all
	}


}

