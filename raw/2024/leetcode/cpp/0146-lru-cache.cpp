#include <list>
#include <map>
#include <utility>

class LRUCache {

private:

    int cap;

    std::map<int, std::list<std::pair<int, int>>::iterator> m;
    std::list<std::pair<int, int>> lst;

    void del(int key) {
        auto it = m.find(key);
        if (it == m.end()) return;
        auto lit = it->second;
        m.erase(it);
        lst.erase(lit);
    }

public:


    LRUCache(int capacity) : cap(capacity) {}
    
    int get(int key) {
        auto it = m.find(key);
        if (it == m.end()) return -1;

        int val = it->second->second;
        del(key);
        put(key, val);
        return val;
    }

    void put(int key, int value) {

        auto it = m.find(key);
        if (it != m.end()) {
            del(key);
        }

        if (m.size() == cap) {
            int k = lst.begin()->first;
            del(k);
        }

        lst.push_back({key, value});
        m.insert({key, --lst.end()});
    }

};
