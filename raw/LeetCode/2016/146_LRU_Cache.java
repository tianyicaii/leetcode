// https://leetcode.com/problems/lru-cache/


public class LRUCache {


	private class Node {
		int key;  // needed when remove least recent used
		int value;
		Node prev;
		Node next;
		public Node (int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int capacity;
	private int size;
	private Node head;
	private Node tail;
	Map<Integer, Node> map;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size     = 0;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
		map  = new HashMap<>();
	}

	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		Node node = map.get(key);
		// move to end of queue
		removeFromQueue(node);
		appendToQueue(node);
		return node.value;
	}

	public void set(int key, int value) {
		if (!map.containsKey(key)) {  // insert new one
			Node node = new Node(key, value);
			map.put(key, node);  // node's address never change until discarded
			appendToQueue(node);
			size += 1;
		}
		else {  // contains this key
			Node node = map.get(key);
			node.value = value;
			removeFromQueue(node);
			appendToQueue(node);
		}
		
		// check capacity
		if (size > capacity) {
			Node oldest = head.next;
			removeFromQueue(oldest);
			map.remove(oldest.key);  // remove from hash table
			size -= 1;
		}
	}
	
	private void removeFromQueue (Node node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}
	private void appendToQueue (Node node) {
		tail.prev.next = node;
		node.prev = tail.prev;
		node.next = tail;
		tail.prev = node;
	}

}	




	public class LRUCache {

		int capacity;
		LinkedHashMap<Integer, Integer> map;
		
		public LRUCache(int capacity) {
			this.capacity = capacity;
			map  = new LinkedHashMap<>();
		}

		public int get(int key) {
			if (!map.containsKey(key)) return -1;
			int v = map.get(key);
			map.remove(key);
			map.put(key, v);
			return v;
		}

		public void set(int key, int value) {
			if (!map.containsKey(key)) {
				if (map.size() == capacity) {
					Iterator<Integer> it = map.keySet().iterator();
					int first = it.next();
					map.remove(first);
				}
				map.put(key, value);
			} else {
				map.remove(key);
				map.put(key, value);
			}
		}
	}	

