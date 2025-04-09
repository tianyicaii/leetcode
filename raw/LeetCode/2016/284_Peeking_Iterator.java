// https://leetcode.com/problems/peeking-iterator/


public class PeekingIterator implements Iterator<Integer> {
	

	Integer lookAhead;
	Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		if (iterator.hasNext()) lookAhead = iterator.next();
		else                    lookAhead = null;
	}

	public Integer peek() {
		return lookAhead;
	}

	public Integer next() {
		Integer ans = lookAhead;
		if (iterator.hasNext()) lookAhead = iterator.next();
		else                    lookAhead = null;
		return ans;
	}

	public boolean hasNext() {
		return lookAhead != null;
	}

}


