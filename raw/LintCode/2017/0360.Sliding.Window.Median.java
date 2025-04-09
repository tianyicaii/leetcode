/*
 *  http://www.lintcode.com/en/problem/sliding-window-median/#
 *
 *  Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array,
 *  find the median of the element inside the window at each moving.
 *  (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )
 */


// hash heap
	private class Node implements Comparable<Node> {
		int index;
		int value;
		public Node (int i, int v) {
			index = i;
			value = v;
		}
		public int compareTo (Node other) {
			if (this.value == other.value) return this.index - other.index;
			else return this.value - other.value;
		}
	}
	
	private class HashHeap {
		
		HashMap<Integer, Integer> map = new HashMap<>();  // given index of input array, find location on heap.
		ArrayList<Node> heap = new ArrayList<>();
		boolean reverseOrder;
		
		private HashHeap (boolean maxHeap) {
			heap.add(new Node(0, 0));  // dummy
			reverseOrder = maxHeap;
		}
		
		void add (Node x) {
			heap.add(x);
			map.put(x.index, heap.size() - 1);
			swim(heap.size() - 1);
		}
		
		Node top () {
			return heap.get(1);
		}
		
		Node poll () {
			Node x = heap.get(1);
			swap(1, heap.size() - 1);
			heap.remove(heap.size() - 1);
			map.remove(x.index);
			sink(1);
			return x;
		}
		
		void remove (Node x) {
			int heapIndex = map.get(x.index);
			swap(heapIndex, heap.size() - 1);
			heap.remove(heap.size() - 1);
			map.remove(x.index);
			if (heapIndex != heap.size()) {  // !!! can move either way.
				sink(heapIndex);
				swim(heapIndex);				
			}
		}
		
		void swim (int i) {
			while (true) {
				if (i == 1) break;
				int p = i / 2;
				if (reverseOrder && heap.get(i).compareTo(heap.get(p)) <= 0) break;
				if (!reverseOrder && heap.get(i).compareTo(heap.get(p)) >= 0) break;
				swap(i, p);
				i = p;
			}
		}
		
		void sink (int i) {
			while (true) {
				if (2 * i >= heap.size()) return;
				int c = 2 * i;
				if (reverseOrder && c + 1 < heap.size() && heap.get(c).compareTo(heap.get(c + 1)) <= 0) c = c + 1;
				if (!reverseOrder && c + 1 < heap.size() && heap.get(c).compareTo(heap.get(c + 1)) >= 0) c = c + 1;
				if (reverseOrder && heap.get(i).compareTo(heap.get(c)) >= 0) break;
				if (!reverseOrder && heap.get(i).compareTo(heap.get(c)) <= 0) break;
				swap(i, c);
				i = c;
			}
			
		}
		
		void swap (int i, int j) {
			Node t = heap.get(i);
			heap.set(i, heap.get(j));
			heap.set(j, t);
			map.put(heap.get(i).index, i);
			map.put(heap.get(j).index, j);
		}
		
		boolean isEmpty () { return map.isEmpty(); }
		int size () { return map.size(); }
	}

	private class Window {
		HashHeap left  = new HashHeap(true);
		HashHeap right = new HashHeap(false);
		
		void add (Node x) {
			if (left.isEmpty()) left.add(x);
			else if (x.compareTo(left.top()) > 0) right.add(x);
			else left.add(x);
			balance();
		}
		
		void balance () {
			if (left.size() == right.size() - 1) left.add(right.poll());
			else if (left.size() == right.size() + 2) right.add(left.poll());
			else ;
		}

		void remove (Node x) {
			if (x.compareTo(left.top()) > 0) right.remove(x);
			else left.remove(x);
			balance();
		}

		Node getMedian () {
			return left.top();
		}
	}
	
	public List<Integer> medianSlidingWindow (int[] nums, int k) {
		List<Integer> ans = new ArrayList<>();
		Window w = new Window();
		int i = 0;
		while (i < k-1 && i < nums.length) {
			w.add(new Node(i, nums[i]));
			++ i;
		}
		while (i < nums.length) {
			w.add(new Node(i, nums[i]));
			ans.add(w.getMedian().value);
			w.remove(new Node(i-k+1, nums[i-k+1]));
			++ i;
		}
		return ans;
	}




// tree set
	private class Node implements Comparable<Node> {  // need to pair value with index to handle duplicates
		int index;  // remove node with smaller index first
		int value;
		public Node (int i, int v) {
			index = i;
			value = v;
		}
		public int compareTo (Node other) {
			if (this.value == other.value) return this.index - other.index;
			return this.value - other.value;
		}
	}

	private class Window {
		TreeSet<Node> left  = new TreeSet<>();
		TreeSet<Node> right = new TreeSet<>();
		void add (Node x) {
			if (left.isEmpty()) left.add(x);
			else if (x.value > left.last().value) right.add(x);
			else left.add(x);
			balance();
		}
		void balance () {
			if (left.size() == right.size() - 1) {
				Node x = right.pollFirst();
				left.add(x);
			} else if (left.size() == right.size() + 2) {
				Node x = left.pollLast();
				right.add(x);
			}
		}
		void remove (Node x) {
			if (x.value > left.last().value) right.remove(x);
			else left.remove(x);
			balance();
		}
		Node getMedian () {
			return left.last();
		}
	}
	
	public List<Integer> medianSlidingWindow (int[] nums, int k) {
		List<Integer> ans = new ArrayList<>();
		Window w = new Window();
		int i = 0;
		while (i < k-1 && i < nums.length) {
			w.add(new Node(i, nums[i]));
			++ i;
		}
		while (i < nums.length) {
			w.add(new Node(i, nums[i]));
			ans.add(w.getMedian().value);
			w.remove(new Node(i-k+1, nums[i-k+1]));
			++ i;
		}
		return ans;
	}
