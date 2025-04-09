// https://leetcode.com/problems/restore-ip-addresses/


public class Solution {
	

	public List<String> restoreIpAddresses (String s) {
		List<String> ans = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		helper(ans, path, s, 0);
		return ans;
	}	
	private void helper (List<String> ans, List<Integer> path, String s, int index) {
		if (index == s.length()) {
			if (path.size() == 4) {
				StringBuilder ip = new StringBuilder();
				ip.append(path.get(0));
				ip.append('.');
				ip.append(path.get(1));
				ip.append('.');
				ip.append(path.get(2));
				ip.append('.');
				ip.append(path.get(3));
				ans.add(ip.toString());
			}
			return;
		}
		if (path.size() == 4) return;
		if (s.charAt(index) == '0') {
			path.add(0);
			helper(ans, path, s, index + 1);
			path.remove(path.size()-1);
			return;
		}
		
		for (int i = 1; i <= 3 && i <= s.length() - index; i++) {  // length of this sub interval
			int val = Integer.parseInt(s.substring(index, index + i));
			if (val > 255) return;
			path.add(val);
			helper(ans, path, s, index + i);
			path.remove(path.size() - 1);
		}
	}


}

