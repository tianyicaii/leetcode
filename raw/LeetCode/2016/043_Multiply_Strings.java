

public class Solution {


/*	
	     99
		 99
	   ----
		 81
		81
		
	    81
	   81	 
	   
	   
	   lenghtC = lengthA + lengthB;
	   index ic = lengthC - (shift) - 1;
	   shift = shiftA + shiftB
	   shiftA = lengthA - j - 1
	   shiftB = lengthB - i - 1
	   index ic = i + j + 1

*/	
	

	public String multiply (String num1, String num2) {
		
		char[] a   = num1.toCharArray();
		char[] b   = num2.toCharArray();
		int [] ans = new int[a.length + b.length];
		
		for (int i = b.length - 1; i >= 0; i--) {
			int c = 0;
			for (int j = a.length - 1; j >= 0; j--) {
				int sum = (a[j] - '0') * (b[i] - '0') + c + ans[i + j + 1];
				c = sum / 10;
				ans[i + j + 1] = sum % 10;
			}
			ans[i] = c;
			
		}
		
		// get result
		int i = 0;
		while (i < ans.length && ans[i] == 0) i++;
		if (i == ans.length) return "0";  // all zero
		
		StringBuilder product = new StringBuilder();
		while (i < ans.length) {
			product.append(ans[i]);
			i++;
		}
		return product.toString();
		
	}


}

