

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

ListNode * detectCycle(ListNode * head) {

    if (!head || !head->next) return nullptr;

    ListNode * slow = head;
    ListNode * fast = head->next;
    bool has_cycle = false;

    while (fast && fast->next) {
        if (slow == fast) { has_cycle = true; break; }
        slow = slow->next;
        fast = fast->next->next;
    }
    if (!has_cycle) return nullptr;

    fast = fast->next;
    slow = head;
    while (fast != slow) {
        fast = fast->next;
        slow = slow->next;
    }
    return slow;
}
