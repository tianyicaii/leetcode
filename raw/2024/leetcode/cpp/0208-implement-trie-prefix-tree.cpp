#include <memory>
#include <string>
#include <vector>


class Trie {

    std::vector<std::unique_ptr<Trie>> children {26};
    bool is_word = false;

public:

    Trie() {}
    
    void insert(const std::string & word) {

        Trie * curr = this;
        for (int i = 0; i < word.size(); ++i) {
            char c = word[i];
            int idx = c - 'a';

            if (!curr->children[idx]) curr->children[idx].reset(new Trie);
            curr = curr->children[idx].get();
        }
        curr->is_word = true;
    }

    bool search(const std::string & word) {
        Trie * curr = this;
        for (int i = 0; i < word.size(); ++i) {
            char c = word[i];
            int idx = c - 'a';
            if (!curr->children[idx]) return false;
            curr = curr->children[idx].get();
        }
        return curr->is_word;
    }
    
    bool startsWith(const std::string & prefix) {
        Trie * curr = this;
        for (int i = 0; i < prefix.size(); ++i) {
            char c = prefix[i];
            int idx = c - 'a';
            if (!curr->children[idx]) return false;
            curr = curr->children[idx].get();
        }
        return true;
    }

};
