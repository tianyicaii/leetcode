
bool isPowerOfFour(int n) {

    if (n <= 0) return false;

    int remove_last_bit = n & (n-1);
    if (remove_last_bit != 0) return false;
    int mask = 0x55555555;
    return mask & n;

}
