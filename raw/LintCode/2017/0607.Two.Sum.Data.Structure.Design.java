/*
 *  http://www.lintcode.com/en/problem/two-sum-data-structure-design/
 *
 *  Design and implement a TwoSum class. It should support the following operations: add and find.
 *      add - Add the number to an internal data structure.
 *      find - Find if there exists any pair of numbers which sum is equal to the value.
 */

    Map<Integer, Integer> cnt = new HashMap<>();

    public void add (int number) {
        if (!cnt.containsKey(number)) cnt.put(number, 0);
        cnt.put(number, cnt.get(number) + 1);
    }

    public boolean find (int value) {
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int x = e.getKey();
            int y = value - x;
            if (x == y) {
                if (cnt.get(x) > 1) return true;
            }
            else {
                if (cnt.containsKey(y)) return true;
            }
        }
        return false;
    }
