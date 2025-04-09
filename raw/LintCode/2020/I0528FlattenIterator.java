package lintcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

public class I0528FlattenIterator {
    

    public class NestedIterator implements Iterator<Integer> {

        Stack<Deque<NestedInteger>> previousLevels = new Stack<>();
        Deque<NestedInteger> currentLevel = new ArrayDeque<>();

        public NestedIterator(List<NestedInteger> nestedList) { fillNewLevel(nestedList); }
    
        @Override
        public Integer next() {
            if (hasNext()) return currentLevel.pollFirst().getInteger();
            else return null;
        }
        
        private void fillNewLevel(List<NestedInteger> list) { for (NestedInteger i : list) currentLevel.offerLast(i); }

        @Override
        public boolean hasNext() {
            while (!previousLevels.isEmpty() || !currentLevel.isEmpty()) {
                if (currentLevel.isEmpty()) currentLevel = previousLevels.pop();
                else {
                    if (currentLevel.peekFirst().isInteger()) return true;
                    List<NestedInteger> list = currentLevel.pollFirst().getList();
                    previousLevels.push(currentLevel);
                    currentLevel = new ArrayDeque<>();
                    fillNewLevel(list);                    
                }
            }
            return false;
        }
    
        @Override
        public void remove() {}
    }

}
