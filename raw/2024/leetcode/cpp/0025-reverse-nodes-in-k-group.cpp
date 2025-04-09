

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};



bool has_k_or_more(ListNode * head, int k) {
    int len = 0;
    while (head != nullptr) {
        len += 1;
        head = head->next;
        if (len >= k) { return true; }
    }
    return false;
}

ListNode * reverse_first_k(ListNode * head, int k) {
    ListNode dummy;
    ListNode * prev = &dummy;
    ListNode * prev_tail = head;
    for (int i = 0; i < k; i++) {
        auto next = head->next;
        head->next = prev->next;
        prev->next = head;
        head = next;
    }
    prev_tail->next = head;  // keep the rest
    return dummy.next;
}

ListNode* reverseKGroup(ListNode* head, int k) {

    ListNode dummy(0, head);
    ListNode *prev = &dummy;

    while (has_k_or_more(prev->next, k)) {
        ListNode * prev_tail = prev->next;
        prev->next = reverse_first_k(prev->next, k);
        prev = prev_tail;
    }

    return dummy.next;
}

