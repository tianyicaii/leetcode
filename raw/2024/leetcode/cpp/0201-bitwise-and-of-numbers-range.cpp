

int rangeBitwiseAnd(int left, int right) {

    int shift = 0;
    while (left != right) {
        left >>= 1;
        right >>= 1;
        shift += 1;
    }
    right <<= shift;
    return right;
}
