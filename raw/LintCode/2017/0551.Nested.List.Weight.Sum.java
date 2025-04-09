/*
 *  http://www.lintcode.com/en/problem/nested-list-weight-sum/
 *
 *  Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *  Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */

// We are able to treat it as a tree and do bfs,
// able to bfs because adding (process) elements on one level does not wait for lower levels.
// Compared to nested expression, parenthesised subexpression has to be evaluated first.

	public int depthSum (List<NestedInteger> nestedList) {
		
		Queue<NestedInteger> q = new LinkedList<>();
		for (NestedInteger i : nestedList) q.offer(i);

		int sum = 0;
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			level += 1;
			for (int i = 0; i < size; i++) {
				NestedInteger x = q.poll();
				if (x.isInteger()) sum += x.getInteger() * level;
				else {
					for (NestedInteger e : x.getList()) q.offer(e);
				}				
			}
		}
		return sum;
	}		


// or use stack, take it as nested expression.