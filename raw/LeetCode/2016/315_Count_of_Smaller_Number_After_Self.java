// https://leetcode.com/problems/count-of-smaller-numbers-after-self/


public class Solution {

	public class Pair {
		int idx;  // original index in input array, restore original order in the end
		int val;  // sort by val
		int cnt;  // count number of element shifted to the front of it.
		public Pair (int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

	public class ByIdx implements Comparator<Pair> {
		public int compare (Pair a, Pair b) {
			return a.idx - b.idx;
		}
	}

	public List<Integer> countSmaller(int[] nums) {

		Pair[] pairs = new Pair[nums.length];
		for (int i = 0; i < nums.length; i++) {
			pairs[i] = new Pair(i, nums[i]);
		}
		mergeSort(pairs, 0, pairs.length - 1);
		
		// write result
		Arrays.sort(pairs, new ByIdx());  // restore original order
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			ans.add(pairs[i].cnt);
		}
		return ans;
	}

	public void mergeSort(Pair[] pairs, int left, int right) {
		if (left >= right) return;
		int mid = left + (right - left) / 2;
		mergeSort(pairs, left, mid);
		mergeSort(pairs, mid + 1, right);
		merge(pairs, left, mid, right);
	}

	public void merge (Pair[] pairs, int left, int mid, int right) {
		int length = right - left + 1;
		Pair[] ans = new Pair[length];
		int cnt = 0;  // a little DP
		int L = left;
		int R = mid + 1;
		for (int i = 0; i < length; i++) {
			if (L == mid + 1) {
				ans[i] = pairs[R ++];
			}
			else if (R == right + 1) {
				ans[i] = pairs[L ++];
				ans[i].cnt += cnt;
			}
			else if (less(pairs, R, L)) {
				ans[i] = pairs[R ++];
				cnt += 1;
			}
			else {
				ans[i] = pairs[L ++];
				ans[i].cnt += cnt;
			}
		}
		for (int i = 0; i < length; i++)
			pairs[left + i] = ans[i];
	}

	public boolean less (Pair[] pairs, int i, int j) {
		return pairs[i].val < pairs[j].val;
	}

	public void swap (Pair[] pairs, int i, int j) {
		Pair tmp = pairs[i];
		pairs[i] = pairs[j];
		pairs[j] = tmp;
	}


}

