
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


ListNode* oddEvenList(ListNode* head) {

    ListNode odd;
    ListNode even;
    ListNode * tail_odd = &odd;
    ListNode * tail_even = &even;


    bool is_odd = true;
    while (head) {

        ListNode * next = head->next;
        head->next = nullptr;
        if (is_odd) {
            tail_odd->next = head;
            tail_odd = head;
        } else {
            tail_even->next = head;
            tail_even = head;
        }
        head = next;
        is_odd = !is_odd;
    }

    tail_odd->next = even.next;
    return odd.next;
}