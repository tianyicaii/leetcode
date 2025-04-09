#include <vector>

class Vector2D {

    std::vector<std::vector<int>>::iterator r_b;
    std::vector<std::vector<int>>::iterator r_e;
    std::vector<int>::iterator c_b;
    std::vector<int>::iterator c_e;

public:

    Vector2D(std::vector<std::vector<int>>& vec) {
        r_b = vec.begin();
        r_e = vec.end();
        if (r_b != r_e) {
            c_b = r_b->begin();
            c_e = r_b->end();
        }
    }
    
    int next() {
        hasNext();
        return *c_b++;
    }
    
    bool hasNext() {
        while (c_b == c_e && r_b != r_e) {
            ++r_b;
            if (r_b == r_e) return false;
            c_b = r_b->begin();
            c_e = r_b->end();
        }
        return c_b != c_e;
    }
};
