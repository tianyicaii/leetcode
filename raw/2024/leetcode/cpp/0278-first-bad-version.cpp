

extern bool isBadVersion(int version);

int firstBadVersion(int n) {

    int left = 0;
    int right = n;

    while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) right = mid;
        else left = mid;
    }

    return right;
}
