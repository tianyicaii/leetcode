// https://leetcode.com/problems/find-the-celebrity/


public class Solution {
	

	public int findCelebrity (int n) {
		
		
		// guess
		int candi = 0;
		for (int i = 1; i < n; i++) {  
			// if i knows candi, then i is not celebrity,
			// if i does not know candi, then candi is not celebrity.
			if (!knows(i, candi)) candi = i;
			// i is the next candidate
		}
		
		// check
		for (int i = 0; i < n; i++) {
			if (i != candi && !knows(i, candi)) return -1;
			if (i != candi &&  knows(candi, i)) return -1;
		}
		
		return candi;
	}	


}

