/*
 *  http://www.lintcode.com/en/problem/top-k-frequent-words/
 *
 *  Given a list of words and an integer k, return the top k frequent words in the list.
 */

	private class Word implements Comparable<Word>{
		String word;
		int count;
		public Word (String word, int count) {
			this.word = word;
			this.count = count;
		}
		public int compareTo (Word other) {
			if (this.count == other.count)
				return other.word.compareTo(this.word);
			return this.count - other.count;
		}
	}

	public String[] topKFrequentWords (String[] words, int k) {

		Map<String, Integer> count = new HashMap<>();
		for (String s : words) {
			if (!count.containsKey(s)) count.put(s, 0);
			count.put(s, count.get(s) + 1);
		}

		PriorityQueue<Word> pq = new PriorityQueue<>();
		for (Map.Entry<String, Integer> e : count.entrySet()) {
			pq.offer(new Word(e.getKey(), e.getValue()));
			if (pq.size() > k) pq.poll();
		}

		String[] ans = new String[k];
		for (int i = k-1; i >= 0; i--) ans[i] = pq.poll().word;
		return ans;
		
	}
