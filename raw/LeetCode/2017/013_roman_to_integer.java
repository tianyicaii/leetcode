

	Map<Character, Integer> m = new HashMap<Character, Integer>(){{
		put('M', 1000);
		put('D', 500);
		put('C', 100);
		put('L', 50);
		put('X', 10);
		put('V', 5);
		put('I', 1);
	}};

	public int romanToInt (String s) {
		int prev = 0;
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			int curr = m.get(s.charAt(i));
			ans += curr;
			if (curr > prev) {
				ans -= 2 * prev;
			}
			prev = curr;
		}
		return ans;
	}