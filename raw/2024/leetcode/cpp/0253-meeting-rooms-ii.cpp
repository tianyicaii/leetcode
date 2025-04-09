#include <algorithm>
#include <vector>

enum class PointType {START, END};

class Point {
    int x;
public:
    PointType t;
    Point(int x_, PointType t_): x(x_), t(t_) {}
    bool operator< (const Point & other) const {
        if (x == other.x) {
            if (t == PointType::END && other.t == PointType::START) return true;
            return false;
        }
        return x < other.x;
    }
};


int minMeetingRooms(std::vector<std::vector<int>>& intervals) {

    std::vector<Point> pts;
    for (const auto & i : intervals) {
        pts.push_back(Point(i[0], PointType::START));
        pts.push_back(Point(i[1], PointType::END));
    }
    std::sort(pts.begin(), pts.end());

    int max_overlap = 0;
    int overlap = 0;
    for (const auto & p : pts) {
        if (p.t == PointType::START) overlap += 1;
        else overlap -= 1;
        max_overlap = std::max(max_overlap, overlap);        
    }
    return max_overlap;
}
