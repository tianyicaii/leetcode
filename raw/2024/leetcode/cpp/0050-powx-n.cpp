
double myPow(double x, int n) {

    if (n == 0) { return 1; }

    double ans = 1;
    double xx = x;
    while (n != 1 && n != -1) {
        if (n % 2) { ans *= xx; }
        xx *= xx;
        n /= 2;
    }
    ans *= xx;
    if (n > 0) { return ans; }
    else { return 1.0/ans; }
    return ans;
}
