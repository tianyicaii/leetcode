

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};






void reorderList(ListNode* head) {

    if (!head) return;

    ListNode * slow = head;
    ListNode * fast = head;

    while (fast->next && fast->next->next) {
        fast = fast->next->next;
        slow = slow->next;
    }

    if (!fast->next) {
        // 2k + 1 nodes
        // fast @[2k]
        // slow @[k]
        ;
    } else {  // 2k + 2 nodes
        // 2k + 2 nodes
        // fast @[2k]
        // slow @[k]
        ;
    }

    ListNode * second_head = slow->next;
    slow->next = nullptr;

    ListNode d;
    while (second_head) {
        ListNode * next = second_head->next;
        second_head->next = d.next;
        d.next = second_head;
        second_head = next;
    }
    second_head = d.next;

    d.next = nullptr;
    ListNode * prev = &d;
    while (head || second_head) {
        if (head) {
            prev->next = head;
            head = head->next;
            prev = prev->next;
        }
        if (second_head) {
            prev->next = second_head;
            second_head = second_head->next;
            prev = prev->next;
        }
    }
}
