// https://leetcode.com/problems/insert-delete-getrandom-o1/


public class RandomizedSet {


	Map<Integer, Integer> map;  // O(1) look up need hash table
	List<Integer> list;  // get random needs random access 

	
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val);
        if (index == list.size() - 1) {  // last one
        	map.remove(val);
        	list.remove(list.size() - 1);
        }
        else {
        	int tailVal = list.get(list.size() - 1);
        	list.set(index, tailVal);
        	list.remove(list.size() - 1);
        	map.remove(val);
        	map.put(tailVal, index);
        }

        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }
}
