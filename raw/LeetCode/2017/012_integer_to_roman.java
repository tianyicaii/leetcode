
	int[] I    = {1000, 900,  500, 400,  100, 90,   50,  40,   10,  9,    5,   4,    1};
    String[] R = {"M",  "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public String intToRoman (int num) {
    		StringBuilder ans = new StringBuilder();
    		int i = 0;
    		while (num > 0) {
    			int q = num / I[i];
    			for (int j = 0; j < q; j++) {
    				ans.append(R[i]);
    				num -= I[i];
    			}
    			i++;  // will not go use unit left to i
    		}
    		return ans.toString();
	}
