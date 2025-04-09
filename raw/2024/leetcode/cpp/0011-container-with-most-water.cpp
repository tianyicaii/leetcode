#include <algorithm>
#include <vector>


int area(std::vector<int>::iterator left, std::vector<int>::iterator right) {
    return (int)((right - left) * std::min(*right, *left));
}

int maxArea(std::vector<int>& height) {

    if (height.size() < 2) { return 0; }

    auto left = height.begin();
    auto right = height.end() - 1;
    int max_area = 0;

    while (left != right) {
        max_area = std::max(max_area, area(left, right));
        if (*left < *right) { left ++; }
        else { right --; }
    }

    return max_area;
}
