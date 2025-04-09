// https://leetcode.com/problems/compare-version-numbers/


public class Solution {


	public int compareVersion(String version1, String version2) {
		String[] V1 = version1.split("\\.");
		String[] V2 = version2.split("\\.");
		
		int i = 0;
		int j = 0;
		
		while (i != V1.length || j != V2.length) {
            int v1 = 0;
            int v2 = 0;
            if (i < V1.length) v1 = Integer.parseInt(V1[i++]);
            if (j < V2.length) v2 = Integer.parseInt(V2[j++]);
			if (v1 > v2) return  1;
			if (v1 < v2) return -1;
			// else continue
		}
		return 0;	
	}	


}

