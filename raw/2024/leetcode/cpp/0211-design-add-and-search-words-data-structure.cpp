#include <memory>
#include <string>
#include <vector>


class Trie {

private:

    std::vector<std::unique_ptr<Trie>> children{26};
    bool is_word = false;

public:

    void add(const std::string & word) {
        Trie * curr = this;
        for (int i = 0; i < word.size(); ++i) {
            char c = word[i];
            int idx = c - 'a';
            if (!curr->children[idx]) curr->children[idx].reset(new Trie);
            curr = curr->children[idx].get();
        }
        curr->is_word = true;
    }


    bool search(Trie * t, int i, const std::string & word) {
        if (i == word.size()) return t->is_word;
        char c = word[i];
        if (c == '.') {
            for (auto & n : t->children) {
                if (!n) continue;
                if (search(n.get(), i+1, word)) return true;
            }
            return false;
        } else {
            int idx = c - 'a';
            if (!t->children[idx]) return false;
            return search(t->children[idx].get(), i+1, word);
        }
    }

    bool search(const std::string & word) {
        return search(this, 0, word);
    }

};


class WordDictionary {

    Trie t;

public:
    WordDictionary() {}
    
    void addWord(std::string word) {
        t.add(word);
    }
    
    bool search(std::string word) {
        return t.search(word);
    }

};
