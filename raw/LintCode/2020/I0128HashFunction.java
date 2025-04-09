package lintcode;

public class I0128HashFunction {
    
    public int hashCode(char[] key, int HASH_SIZE) {

        long hash = 0;
        for (char c : key) {
            hash = ((hash * 33) + c) % HASH_SIZE;
        }
        return (int)hash;
    }
}
