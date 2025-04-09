#include <functional>
#include <vector>
#include <queue>

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


ListNode* mergeKLists(std::vector<ListNode*>& lists) {

    std::priority_queue<ListNode *, std::vector<ListNode *>, std::function<bool (ListNode* , ListNode *)>> pq([](ListNode * a, ListNode * b) { return a->val > b->val; });
    for (auto it = lists.begin(); it != lists.end(); it++) {
        if (*it) {
            pq.push(*it);
        }
    }
    ListNode dummy;
    ListNode *prev = &dummy;
    while (!pq.empty()) {
        auto min = pq.top();
        pq.pop();
        prev->next = min;
        prev = prev->next;
        if (min->next) {
            pq.push(min->next);
        }
    }
    return dummy.next;
}
