package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class I0391NumberOfPlanesInTheSky {
    
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    enum Type { START, END }
    
    class Point implements Comparable<Point> {
        int time;
        Type type;
        Point(int time, Type type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Point other) {
            if (this.time == other.time) {
                if (this.type == other.type) return 0;
                if (this.type == Type.END) return -1;
                return 1;
            } else if (this.time < other.time) return -1;
            return 1;
        }
    }

    public int countOfAirplanes(List<Interval> airplanes) {

        ArrayList<Point> points = new ArrayList<>();
        for (Interval i : airplanes) {
            points.add(new Point(i.start, Type.START));
            points.add(new Point(i.end, Type.END));
        }
        Collections.sort(points);

        int ans = 0;
        int curr = 0;

        for (Point p : points) {
            if (p.type == Type.START) curr += 1;
            else curr -= 1;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
