/*
 *  http://www.lintcode.com/en/problem/intersection-of-two-arrays/
 *
 *  Given two arrays, write a function to compute their intersection.
 *  Each element in the result must be unique.
 */


// sort
	public int[] intersection (int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> intersection = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				if (intersection.isEmpty() || intersection.get(intersection.size() - 1) != nums1[i]) {  // ignore duplicated elements
					intersection.add(nums1[i]);
				}
				++i;
				++j;
			} else if (nums1[i] < nums2[j]) {
				++i;
			} else {
				++j;
			}
		}
		
		int [] ans = new int[intersection.size()];
		for (int k = 0; k < ans.length; k++) {
			ans[k] = intersection.get(k);  // cannot determin array size up front.
		}
		return ans;
	}


// map
	public int[] intersection (int[] nums1, int[] nums2) {
		List<Integer> intersection = new ArrayList<>();
		Map<Integer, Integer> count = new HashMap<>();
		for (int i : nums1) {
			if (!count.containsKey(i)) count.put(i, 1);
		}
		for (int i : nums2) {
			if (count.containsKey(i) && count.get(i) == 1) {
				intersection.add(i);
				count.put(i, 2);  // so that it won't be matched again
			}
		}

		int[] ans = new int[intersection.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = intersection.get(i);
		}
		return ans;

	}


// binary search
	public int[] intersection (int[] nums1, int[] nums2) {
		List<Integer> intersection = new ArrayList<>();

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		for (int i = 0; i < nums1.length; i++) {
			if (i != 0 && nums1[i] == nums1[i-1]) continue;  // ignore duplicate elements
			if (find(nums2, nums1[i])) intersection.add(nums1[i]);
		}
		
		int[] ans = new int[intersection.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = intersection.get(i);
		}
		return ans;

	}
	
	private boolean find (int[] A, int k) {
		if (A.length == 0) return false;
		if (A[0] == k) return true;
		if (A[A.length - 1] == k) return true;
		if (A[0] > k) return false;
		if (A[A.length - 1] < k) return false;
		
		int left = 0;
		int right = A.length - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (A[mid] == k) return true;
			if (A[mid] > k) right = mid;
			else left = mid;
		}
		return false;
	}
