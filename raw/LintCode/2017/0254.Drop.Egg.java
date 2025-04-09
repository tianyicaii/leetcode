/*
 *  http://www.lintcode.com/en/problem/drop-eggs/
 *
 *  There is a building of n floors.
 *  If an egg drops from the k th floor or above, it will break. If it's dropped from any floor below, it will not break.
 *  You're given two eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the worst case.
 */

	public int dropEggs (int n) {
		
		//  find x such that Math.max(f(x - 1), f(n - x)) is smallest

		//  find smallest x such that x + (x-1) + (x-2) + ... + 1 >= n
		//  total number of drop is x
		//  first drop is at floor x
		
		long x = 0;
		long sum = 0;
		while (sum < n) {
			x += 1;
			sum += x;
		}
		return (int)x;
	}
