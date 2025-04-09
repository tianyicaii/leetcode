#include <vector>

class Iterator {
    struct Data;
    Data* data;
public:
    Iterator(const std::vector<int>& nums);
    Iterator(const Iterator& iter);

    // Returns the next element in the iteration.
    int next();

    // Returns true if the iteration has more elements.
    bool hasNext() const;
};


class PeekingIterator : public Iterator {

    int top;
    bool cached;

public:
	PeekingIterator(const std::vector<int>& nums) : Iterator(nums) {
	    // Initialize any member here.
	    // **DO NOT** save a copy of nums and manipulate it directly.
	    // You should only use the Iterator interface methods.
        if (Iterator::hasNext()) {
            top = Iterator::next();
            cached = true;
        } else {
            top = 0;
            cached = false;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	int peek() {
        return top;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	int next() {
	    int v = top;
        if (Iterator::hasNext()) {
            top = Iterator::next();
            cached = true;
        } else {
            top = 0;
            cached = false;
        }
        return v;
	}
	
	bool hasNext() const {
	    return cached;
	}
};