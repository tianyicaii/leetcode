// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/


public class RandomizedCollection {


	Map<Integer, Set<Integer>> map;
	ArrayList<Integer> list;  // array for random access


    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
        	map.get(val).add(list.size());
        	list.add(val);
        	return false;
        }
        else {  // does not contain
        	map.put(val, new HashSet<>());
        	map.get(val).add(list.size());
        	list.add(val);
        	return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Set<Integer> idx = map.get(val);

        if (idx.contains(list.size() - 1)) {  // last element on list

        	if (idx.size() == 1) {
        		map.remove(val);	
        	}
        	else {
        		map.get(val).remove(list.size() - 1);
        	}
        	list.remove(list.size() - 1);
        }

        else {
        	int i = idx.iterator().next();
        	int tailVal = list.get(list.size() - 1);

        	if (idx.size() == 1) {
        		map.remove(val);
        	}
        	else {
        		map.get(val).remove(i);
        	}

       		map.get(tailVal).remove(list.size() - 1);
        	map.get(tailVal).add(i);
        	list.set(i, tailVal);
        	list.remove(list.size() - 1);
        }

        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int i = (int) (Math.random() * (list.size()));
        return list.get(i);
    }


}

