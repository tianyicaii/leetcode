
bool isPalindrome(int x) {

    if (x < 0) return false;

    int mag = 1;
    while (x / mag >= 10) { mag *= 10; }

    while (x > 0) {
        int right = x % 10;
        int left = x / mag;
        if (left != right) return false;
        x = x % mag;
        x = x / 10;
        mag = mag / 100;  // two less digits
    }

    return true;
}
