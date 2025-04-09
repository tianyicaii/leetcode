#include <map>
#include <set>
#include <utility>
#include <vector>


double get_slope(int x1, int y1, int x2, int y2) {
    int dx = x2 - x1;
    int dy = y2 - y1;
    if (dy < 0 && dx < 0) { dy = -dy; dx = -dx; }
    if (dy > 0 && dx < 0) { dy = -dy; dx = -dx; }
    return (double)dy / dx;
}

double get_intercept(int x1, int y1, int x2, int y2) {
    int dx = x2 - x1;
    int dy = y2 - y1;
    int a = dx * y2 - dy * x2;
    int b = dx;
    if (a < 0 && b < 0) { a = -a; b = -b; }
    if (a > 0 && b < 0) { a = -a; b = -b; }
    return (double)a / b;
}


int maxPoints(std::vector<std::vector<int>>& points) {

    int ans = 0;

    std::map<int, std::set<int>> vertical;

    for (int i = 0; i < points.size(); ++i) {
        vertical[points[i][0]].insert(points[i][1]);
    }
    for (const auto & i : vertical) {
        ans = std::max(ans, (int)(i.second.size()));
    }


    std::map<std::pair<double, double>, std::set<int>> lines;

    for (int i = 0; i < points.size(); ++i) {
        for (int j = i + 1; j < points.size(); ++j) {
            if (points[i][0] == points[j][0]) continue;  // vertical

            auto slope = get_slope(points[i][0], points[i][1], points[j][0], points[j][1]);
            auto intercept = get_intercept(points[i][0], points[i][1], points[j][0], points[j][1]);
            lines[{slope, intercept}].insert(points[i][0]);
            lines[{slope, intercept}].insert(points[j][0]);
        }
    }
    for (const auto & i : lines) {
        ans = std::max(ans, (int)(i.second.size()));
    }

    return ans;
}



