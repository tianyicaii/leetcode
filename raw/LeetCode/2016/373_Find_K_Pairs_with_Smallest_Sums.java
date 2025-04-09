// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/


public class Solution {


	public class Cell implements Comparable<Cell> {

		int i;
		int j;
		int x;
		int y;
		
		public Cell (int i, int j, int x, int y) {
			this.i = i;
			this.j = j;
			this.x = x;
			this.y = y;
		}
		public int compareTo (Cell other) {
			return (this.x + this.y) - (other.x + other.y);
		}
		public String getKey () {
			return i + ", " + j;
		}
		public int[] getComponents () {
			return new int[] {x, y};
		}
	}
	
	public List<int[]> kSmallestPairs (int[] nums1, int[] nums2, int k) {
		List<int[]> ans = new ArrayList<>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return ans;
		
		
		int m = nums1.length;
		int n = nums2.length;
		
		PriorityQueue<Cell> heap = new PriorityQueue<>();
		Set<String> seen = new HashSet<>();
		
		Cell curr = new Cell(0, 0, nums1[0], nums2[0]);
		seen.add(curr.getKey());
		ans.add(curr.getComponents());
		
		for (int c = 2; c <= k; c++) {
		
			if (curr.i + 1 < m) {
				int i = curr.i + 1;
				int j = curr.j;
				Cell next = new Cell(i, j, nums1[i], nums2[j]);
				if (!seen.contains(next.getKey())) {
					heap.offer(next);
					seen.add(next.getKey());
				}
			}
			
			if (curr.j + 1 < n) {
				int i = curr.i;
				int j = curr.j + 1;
				Cell next = new Cell(i, j, nums1[i], nums2[j]);
				if (!seen.contains(next.getKey())) {
					heap.offer(next);
					seen.add(next.getKey());
				}
			}
			
			if (heap.isEmpty()) break;
			curr = heap.poll();
			ans.add(curr.getComponents());
		}
		
		return ans;
	}


}

