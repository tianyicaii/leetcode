
	public RandomListNode copyRandomList (RandomListNode head) {
		
		Map<RandomListNode, Integer> node_to_index = new HashMap<RandomListNode, Integer>();
		Map<Integer, RandomListNode> index_to_node = new HashMap<Integer, RandomListNode>();
		Map<RandomListNode, Integer> copy_to_index = new HashMap<RandomListNode, Integer>();
		Map<Integer, RandomListNode> index_to_copy = new HashMap<Integer, RandomListNode>();
		
		RandomListNode curr = head;
		int index = 0;
		while (curr != null) {
			node_to_index.put(curr, index);
			index_to_node.put(index, curr);
			RandomListNode copy = new RandomListNode(curr.label);
			copy_to_index.put(copy, index);
			index_to_copy.put(index, copy);
			curr = curr.next;
			index ++;
		}
		for (Map.Entry<Integer, RandomListNode> e : index_to_copy.entrySet()) {
			int i = e.getKey();
			RandomListNode n = e.getValue();
			n.next = index_to_copy.get(node_to_index.get(index_to_node.get(i).next));
			n.random = index_to_copy.get(node_to_index.get(index_to_node.get(i).random));
		}
		
		return index_to_copy.get(node_to_index.get(head));
	}


	public RandomListNode copyRandomList (RandomListNode head) {
		
		Map<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode curr = head;
		while (curr != null) {
			m.put(curr, new RandomListNode(curr.label));
			curr = curr.next;
		}
		for (Map.Entry<RandomListNode, RandomListNode> e : m.entrySet()) {
			RandomListNode x = e.getKey();
			RandomListNode xx = e.getValue();
			
			xx.next = m.get(x.next);
			xx.random = m.get(x.random);
		}
		
		return m.get(head);
	}


	public RandomListNode copyRandomList (RandomListNode head) {
		
		if (head == null) return null;
		
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode next = curr.next;
			curr.next = new RandomListNode(curr.label);
			curr.next.next = next;
			curr = next;
		}
		curr = head;
		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		RandomListNode ans = head.next;
		curr = head;
		while (curr != null) {
			RandomListNode copy = curr.next;
			curr.next = copy.next;
			if (curr.next != null)
				copy.next = curr.next.next;
			curr = curr.next;
		}
		return ans;
	}
