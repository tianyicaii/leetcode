// https://leetcode.com/problems/moving-average-from-data-stream/


public class MovingAverage {


	Deque<Integer> window;
	int sum;
	int capacity;


	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.capacity = size;
		this.sum = 0;
		this.window = new ArrayDeque<>();		
	}
	
	public double next(int val) {
		window.offerLast(val);
		sum += val;
		if (window.size() > capacity) {
			sum -= window.pollFirst();
		}
		return (double) sum / window.size();
	}


}

