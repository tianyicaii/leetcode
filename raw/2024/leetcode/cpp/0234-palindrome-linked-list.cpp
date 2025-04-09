

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


int length(ListNode * head) {
    int cnt = 0;
    while (head) {
        cnt += 1;
        head = head->next;
    }
    return cnt;
}


bool isPalindrome(ListNode* head) {

    int len = length(head);

    ListNode dummy;

    for (int i = 0; i < len / 2; ++i) {
        ListNode * next = head->next;
        head->next = dummy.next;
        dummy.next = head;
        head = next;
    }

    if (len % 2) head = head->next;
    ListNode * x = dummy.next;
    while (head) {
        if (head->val != x->val) return false;
        head = head->next;
        x = x->next;
    }
    return true;
}