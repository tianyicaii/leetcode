/*
 *  http://www.lintcode.com/en/problem/lfu-cache/
 *
 *  LFU (Least Frequently Used) is a famous cache eviction algorithm.
 *  For a cache with capacity k, if the cache is full and need to evict a key in it, the key with the lease frequently used will be kicked out.
 *  Implement set and get method for LFU cache.
 */


	public class LFUCache {
		
		private class Entry {
			int key;
			int value;
			int frequency = 0;
			public Entry (int k, int v) {
				key = k;
				value = v;
			}
		}

		HashMap<Integer, Entry> entries = new HashMap<>();
		HashMap<Integer, LinkedHashSet<Entry>> frequencyLists = new HashMap<>();  // should be tree map sorted on frequency
		int minFrequency = 0;
		int capacity;

		public LFUCache (int capacity) {
			this.capacity = capacity;
		}

		public void set (int key, int value) {
			if (entries.containsKey(key)) {
				Entry e = entries.get(key);
				promote(e);
				setMinFrequency();
				e.value = value;
			} else {
				if (entries.size() == capacity) removeFirst();
				addNew(new Entry(key, value));
			}
		}

		public int get (int key) {
			if (!entries.containsKey(key)) return -1;
			Entry e = entries.get(key);
			promote(e);
			setMinFrequency();
			return e.value;
		}

		private void addNew (Entry e) {
			entries.put(e.key, e);
			if (!frequencyLists.containsKey(e.frequency)) frequencyLists.put(e.frequency, new LinkedHashSet<>());
			frequencyLists.get(e.frequency).add(e);
			minFrequency = e.frequency;
		}

		private void removeFirst () {
			Entry e = frequencyLists.get(minFrequency).iterator().next();
			frequencyLists.get(minFrequency).remove(e);
			entries.remove(e.key);
			if (frequencyLists.get(minFrequency).isEmpty()) frequencyLists.remove(minFrequency);  // minFrequency will be 1 immediately
		}

		private void promote (Entry e) {
			frequencyLists.get(e.frequency).remove(e);
			e.frequency++;
			if (!frequencyLists.containsKey(e.frequency)) frequencyLists.put(e.frequency, new LinkedHashSet<>());
			frequencyLists.get(e.frequency).add(e);
		}

		private void setMinFrequency () {
			if (!frequencyLists.get(minFrequency).isEmpty()) return;
			frequencyLists.remove(minFrequency);
			while (true) {
				++minFrequency;  // !!! linear
				if (frequencyLists.containsKey(minFrequency)) break;
			}
		}
	}










// hash heap
	public class LFUCache {
		int time = 0;  // break tie for equal frequency.

		private class Entry implements Comparable<Entry> {
			int key;
			int value;
			int counter;
			int t;
			public Entry (int key, int value) {
				this.key = key;
				this.value = value;
				this.counter = 0;
				this.t = time ++;
			}
			public int compareTo (Entry other) {
				if (this.counter == other.counter) return this.t - other.t;  // longer existing record gets evicted first
				return this.counter - other.counter;
			}
			public void touch () { counter ++; t = time++; }
		}

		// hash heap
		Map<Integer, Integer> map = new HashMap<>();  // key to index
		ArrayList<Entry> heap = new ArrayList<>();
		
		private void swap (int i, int j) {
			Entry tmp = heap.get(i);
			heap.set(i, heap.get(j));
			heap.set(j, tmp);
			map.put(heap.get(i).key, i);
			map.put(heap.get(j).key, j);
		}

		public void sink (int i) {
			while (true) {
				if (i * 2 >= heap.size()) break;
				int j = i * 2;
				if (j + 1 < heap.size() && heap.get(j + 1).compareTo(heap.get(j)) < 0) j += 1;
				if (heap.get(i).compareTo(heap.get(j)) < 0) break;
				swap(i, j);
				i = j;
			}
		}

		public void swim (int i) {
			while (true) {
				if (i / 2 == 0) break;
				int j = i / 2;
				if (heap.get(i).compareTo(heap.get(j)) > 0) break;
				swap(i, j);
				i = j;
			}
		}
		
		public Entry getMin () {
			swap(1, heap.size() - 1);
			Entry e = heap.remove(heap.size() - 1);
			map.remove(e.key);
			sink(1);
			return e;
		}


		// cache
		int capacity;
		public LFUCache (int capacity) {
			this.capacity = capacity + 1;  // add one for heap[0]
			heap.add(new Entry(0, 0));
		}
		
		private Entry getEntry (int key) {
			if (!map.containsKey(key)) return null;
			int i = map.get(key);
			heap.get(i).touch();
			sink(i);  // this is not proper hash heap, the frequency can only increase, no need to swim()
			return heap.get(map.get(key));
		}
		
		public void set (int key, int value) {
			Entry e = getEntry(key);
			if (e != null) {
				e.value = value;
			} else {  // add new entry
				if (heap.size() == capacity) getMin();  // remove min
				Entry f = new Entry(key, value);
				int i = heap.size();
				map.put(key, i);
				heap.add(f);
				swim(i);
			}
		}

		public int get (int key) {
			Entry e = getEntry(key);
			return e == null ? -1 : e.value;
		}
	}
