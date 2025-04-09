/*
 *  http://www.lintcode.com/en/problem/permutation-index-ii/#
 *
 *  Given a permutation which may contain repeated numbers,
 *  find its index in all the permutations of these numbers,
 *  which are ordered in lexicographical order.
 *  The index begins at 1.
 */

	long[] factorial;

	private void getFactorials (int size) {
		factorial = new long[size];
		factorial[0] = 1;
		for (int i = 1; i < factorial.length; i++)
			factorial[i] = factorial[i-1] * i;
	}

	private long getNumOfNumbers (Map<Integer, Integer> counts) {  // number of permutations = factorial(N) / (factorial(m_1) * ... * factorial(m_x))
		int totalDigits = 0;
		long denominator = 1;
		for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
			totalDigits += e.getValue();
			denominator *= factorial[e.getValue()];
		}
		return factorial[totalDigits] / denominator;
	}


	public long permutationIndexII (int[] A) {
		getFactorials(A.length + 1);
		Map<Integer, Integer> counts = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (counts.containsKey(A[i])) counts.put(A[i], counts.get(A[i]) + 1);
			else counts.put(A[i], 1);
		}


		long ans = 1;


		for (int i = 0; i < A.length - 1; i++) {
			
			Set<Integer> seen = new HashSet<>();
			
			for (int j = i + 1; j < A.length; j++) {

				if (A[j] < A[i] && !seen.contains(A[j])) {  // if put A[j] at the position i, find how many (distinct) numbers can be generated, only consider distinct A[j]'s
					counts.put(A[j], counts.get(A[j]) - 1);
					ans += getNumOfNumbers(counts);
					counts.put(A[j], counts.get(A[j]) + 1);
					seen.add(A[j]);
				}

			}
			counts.put(A[i], counts.get(A[i]) - 1);
		}

		return ans;
	}
