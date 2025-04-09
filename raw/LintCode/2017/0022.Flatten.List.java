/*

http://www.lintcode.com/en/problem/flatten-list/

Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.
Notice: If the element in the given list is a list, it can contain list too.

*/


	class Frame {
		int index = 0;
		List<NestedInteger> list;
		public Frame (List<NestedInteger> list) {
			this.list = list;
		}
	}
	
	public List<Integer> flatten (List<NestedInteger> nestedList) {
		List<Integer> ans = new ArrayList<>();
		Stack<Frame> callingStack = new Stack<>();
		callingStack.push(new Frame(nestedList));
		while (!callingStack.isEmpty()) {
			Frame f = callingStack.pop();
			for (int i = f.index; i < f.list.size(); i++) {
				NestedInteger e = f.list.get(i);
				f.index ++;
				if (e.isInteger()) {
					ans.add(e.getInteger());
				} else {
					callingStack.push(f);
					callingStack.push(new Frame(e.getList()));
					break;
				}
			}
		}
		
		return ans;
	}




	public List<Integer> flatten (List<NestedInteger> nestedList) {
		
		List<Integer> ans = new ArrayList<>();
		Stack<List<NestedInteger>> prev = new Stack<>();
		Stack<Integer> pos = new Stack<>();
		List<NestedInteger> curr = nestedList;
		int i = 0;
		
		while (i != curr.size() || !prev.isEmpty()) {
			
			if (i == curr.size()) {  // done with this sublist
				curr = prev.pop();
				i = pos.pop();
				continue;
			}
			
			// keep processing current sublist
			NestedInteger x = curr.get(i);
			if (x.isInteger()) {
				ans.add(x.getInteger());
				++ i;
			} else {  // start a new level
				prev.push(curr);
				curr = x.getList();
				++ i;
				pos.push(i);
				i = 0;
			}
		}
		
		return ans;
	}




	interface NestedInteger {
		boolean isInteger ();
		Integer getInteger ();
		List<NestedInteger> getList ();
	}
