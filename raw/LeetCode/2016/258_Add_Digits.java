// https://leetcode.com/problems/add-digits/


public class Solution {


    /*
        0: <-- special case
        1:  10,  19,  28,  37,  46,  55,  64,  73, 82, 91, (+9)
        2:  11,  20,  29,  38,  47,  56,  65,  74, ..
        3:  12,  21,  30,  39,  48,  57,  66,  75, ..
        4:  13,  22,  31,  40,  49,  58,  67,  76, ..
        5:  14,  23,  32,  41,  50,  59,  68,  77,
        6:  15,  24,  33,  42,  51,  60,  69,  78,
        7:  16,  25,  34,  43,  52,  61,  70,  79,
        8:  17,  26,  35,  44,  53,  62,  71,  80,
        9:  18,  27,  36,  45,  54,  63,  72,  81,
    */
    
	public int addDigits(int num) {
		if (num == 0) return 0;
		// n and n + 9x are the same
		int i = 1;
		while (true) {
			if ((num - i) % 9 == 0) return i;
			i += 1;  // try next 
		}
	}


}

