// https://leetcode.com/problems/find-median-from-data-stream/


public class MedianFinder {
	
	
	PriorityQueue<Integer> left  = new PriorityQueue<>(Collections.reverseOrder());  // max heap
	PriorityQueue<Integer> right = new PriorityQueue<>();  // min heap


	public void addNum (int num) {
		if (left.size() == right.size()) {
			right.offer(num);
			left.offer(right.poll());
		}
		else {
			right.offer(left.poll());
			right.offer(num);
			left.offer(right.poll());
		}
	}

	
	public double findMedian () {
		if (left.size() == right.size()) {
			return (left.peek() + right.peek()) / 2.0;
		}
		else
			return left.peek();
	}


}


