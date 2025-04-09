

int mySqrt(int x) {

    if (x == 0) { return 0; }
    if (x == 1) { return 1; }

    int b = 1;
    int e = x;

    while (b < e - 1) {
        int m = b + (e - b) / 2;
        if (m <= x / m) { b = m; }
        else {e = m; }
    }
    return b;
}
