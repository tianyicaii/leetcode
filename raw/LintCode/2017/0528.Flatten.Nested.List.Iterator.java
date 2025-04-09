/*
 *  http://www.lintcode.com/en/problem/flatten-nested-list-iterator/
 *
 *  Given a nested list of integers, implement an iterator to flatten it.
 *  Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */


	public class NestedIterator implements Iterator<Integer> {
		
		Stack<NestedInteger> stack = new Stack<>();

		public NestedIterator(List<NestedInteger> nestedList) {
			pushListToStack(nestedList);
		}

// Or, use a stack of deque, as if in expression evaluation

		private void pushListToStack (List<NestedInteger> nestedList) {  // reverse order
			Stack<NestedInteger> tmp = new Stack<>();
			for (NestedInteger e : nestedList) tmp.push(e);
			while (!tmp.isEmpty()) stack.push(tmp.pop());
		}


		@Override
		public Integer next() {
			if (hasNext()) return stack.pop().getInteger();  // hasNext() make sure to put a Integer on top
			else return null;
		}

		@Override
		public boolean hasNext() {
			while (!stack.isEmpty() && !stack.peek().isInteger())  // expand top of stack
				pushListToStack(stack.pop().getList());  // list can be empty, at which time, no new elements will be pushed to stack
			return !stack.isEmpty();
		}

		@Override
		public void remove() {}
	}








	public class NestedIterator implements Iterator<Integer> {
		
		class Frame {  // each list creates a new level on stack
			int index = 0;  // which element is next to be consumed
			List<NestedInteger> list;
			public Frame (List<NestedInteger> list) {
				this.list = list;
			}
		}
		
		
		Stack<Frame> callingStack = new Stack<>();
		Integer next = null;
		
		
	    public NestedIterator(List<NestedInteger> nestedList) {
			callingStack.push(new Frame(nestedList));
	    }


		public Integer next() {
			if (hasNext()) {
				Integer ans = next;
				next = null;
				return ans;
			} else {
				return null;
			}
		}

		@Override
		public boolean hasNext() {
			if (next != null) return true;
			while (!callingStack.isEmpty()) {
				Frame f = callingStack.pop();
				if (f.index < f.list.size()) {
					NestedInteger e = f.list.get(f.index);
					f.index ++;
					if (e.isInteger()) {
						next = e.getInteger();
						callingStack.push(f);
						return true;
					} else {
						callingStack.push(f);  // push back current frame
						callingStack.push(new Frame(e.getList()));  // start a new frame
					}
				}
			}
			return false;
		}

	    @Override
	    public void remove() {}
	}
