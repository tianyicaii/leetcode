/*

Implement a memcache which support the following features:

get(curtTime, key). Get the key's value, return 2147483647 if key does not exist.
set(curtTime, key, value, ttl). Set the key-value pair in memcache with a time to live (ttl). The key will be valid from curtTime to curtTime + ttl - 1 and it will be expired after ttl seconds. if ttl is 0, the key lives forever until out of memory.
delete(curtTime, key). Delete the key.
incr(curtTime, key, delta). Increase the key's value by delta return the new value. Return 2147483647 if key does not exist.
decr(curtTime, key, delta). Decrease the key's value by delta return the new value. Return 2147483647 if key does not exist.
It's guaranteed that the input is given with increasingcurtTime.


Clarification
    Actually, a real memcache server will evict keys if memory is not sufficient, and it also supports variety of value types like string and integer. In our case, let's make it simple, we can assume that we have enough memory and all of the values are integers.
    Search "LRU" & "LFU" on google to get more information about how memcache evict data.
    Try the following problem to learn LRU cache:
    http://www.lintcode.com/problem/lru-cache

Example
    get(1, 0)
    >> 2147483647
    set(2, 1, 1, 2)
    get(3, 1)
    >> 1
    get(4, 1)
    >> 2147483647
    incr(5, 1, 1)
    >> 2147483647
    set(6, 1, 3, 0)
    incr(7, 1, 1)
    >> 4
    decr(8, 1, 1)
    >> 3
    get(9, 1)
    >> 3
    delete(10, 1)
    get(11, 1)
    >> 2147483647
    incr(12, 1, 1)
    >> 2147483647

*/

    class Value {
        public int value;
        public int ttl;  // expiration time, 0 indicate pined item, timestamp start with 1
        public Value (int value, int ttl) {
            this.value = value;
            this.ttl = ttl;
        }
    }

    public class Memcache {

        Map<Integer, Value> cache = new HashMap<>();  // map key to a value + expiration time pair

        public int get (int currTime, int key) {
            if (!cache.containsKey(key)) return Integer.MAX_VALUE;
            Value v = cache.get(key);
            if (v.ttl == 0 || v.ttl > currTime)
                    return v.value;
            else {
                    cache.remove(key);
                    return Integer.MAX_VALUE;
            }
        }

        public void set (int currTime, int key, int value, int ttl) {
            cache.put(key, new Value(value, (ttl == 0 ? 0 : ttl + currTime)));
        }

        public void delete (int currTime, int key) {  // XXX: does not need currTime
            if (cache.containsKey(key))
                    cache.remove(key);
        }
        
        public int incr (int currTime, int key, int delta) {
            if (get(currTime, key) == Integer.MAX_VALUE)  // not exist or expired
                    return Integer.MAX_VALUE;
            cache.get(key).value += delta;
            return cache.get(key).value;
        }

        public int decr (int currTime, int key, int delta) {
                return incr(currTime, key, - delta);
        }
    }   
