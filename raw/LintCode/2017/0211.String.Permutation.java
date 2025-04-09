/*
 *  http://www.lintcode.com/en/problem/string-permutation/
 *
 *  Given two strings, write a method to decide if one is a permutation of the other.
 */

// sort
	public boolean Permutation (String A, String B) {
		char[] a = getSorted(A);
		char[] b = getSorted(B);
		return Arrays.equals(a, b);
	}	
	
	private char[] getSorted (String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return a;
	}

// map
	public boolean Permutation (String A, String B) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < A.length(); i++) {
			if (!m.containsKey(A.charAt(i))) m.put(A.charAt(i), 0);
			m.put(A.charAt(i), m.get(A.charAt(i)) + 1);
		}
		for (int i = 0; i < B.length(); i++) {
			if (!m.containsKey(B.charAt(i))) return false;
			if (m.get(B.charAt(i)) == 0) return false;
			m.put(B.charAt(i), m.get(B.charAt(i)) - 1);
			if (m.get(B.charAt(i)) == 0) m.remove(B.charAt(i));
		}
		return m.size() == 0;
	}	
