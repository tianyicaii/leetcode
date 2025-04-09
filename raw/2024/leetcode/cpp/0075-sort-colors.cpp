#include <vector>


void swap(int & a, int & b) {
    int t = a;
    a = b;
    b = t;
}

void sortColors(std::vector<int>& nums) {

    auto b = nums.begin();
    auto e = nums.end();
    auto i = b;

    while (i < e) {
        if (*i == 0) {
            swap(*i, *b);
            ++b;
            ++i;
        } else if (*i == 1) {
            ++i;
        }
        else { // *i == 2
            swap(*i, *(e-1));
            --e;
        }
    }
}
