
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

int get_len(ListNode * x) {
    int cnt = 0;
    while (x) {
        x = x->next;
        cnt += 1;
    }
    return cnt;
}

ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    ListNode * pa = headA;
    ListNode * pb = headB;

    int sum_len = get_len(headA) + get_len(headB);
    int cnt = 0;

    while (pa != pb && cnt < sum_len) {

        if (!pa->next) pa = headB;
        else pa = pa->next;
        if (!pb->next) pb = headA;
        else pb = pb->next;

        cnt += 1;
    }

    if (cnt == sum_len) return nullptr;
    return pa;
}
