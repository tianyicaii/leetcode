#include <algorithm>
#include <vector>

int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

    int dx = 0;
    if (ax2 < bx1 || ax1 > bx2) dx = 0;
    else {
        std::vector<int> x = {ax1, ax2, bx1, bx2};
        std::sort(x.begin(), x.end());
        dx = x[2] - x[1];
    }

    int dy = 0;
    if (ay2 < by1 || ay1 > by2) dy = 0;
    else {
        std::vector<int> y = {ay1, ay2, by1, by2};
        std::sort(y.begin(), y.end());
        dy = y[2] - y[1];
    }

    return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - dx * dy;
}