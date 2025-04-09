// https://leetcode.com/problems/pascals-triangle-ii/


public class Solution {
	

	public List<Integer> getRow (int rowIndex) {
		List<Integer>[] rows = (List<Integer>[]) new List[2];
		List<Integer> firstRow = new ArrayList<>();
		firstRow.add(1);
		rows[0] = firstRow;
		
		for (int i = 1; i <= rowIndex; i++) {
			List<Integer> currRow = new ArrayList<>();
			List<Integer> prevRow = rows[(i-1) % 2];
			currRow.add(1);
			for (int j = 1; j < i; j++) {
				currRow.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			currRow.add(1);
			rows[i % 2] = currRow;
		}
		return rows[rowIndex % 2];
	}


}

