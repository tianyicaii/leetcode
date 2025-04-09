

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


ListNode t1;
ListNode t2;
ListNode t3;

int get_len(ListNode * head) {
    int cnt = 0;
    while (head) {
        head = head->next;
        cnt += 1;
    }
    return cnt;
}

void split(int i) {
    ListNode * c3 = t3.next;
    ListNode * c1 = &t1;
    ListNode * c2 = &t2;
    while (c3) {
        for (int j = 0; j < i && c3; ++j) {
            c1->next = c3;
            c1 = c1->next;
            c3 = c3->next;
        }
        for (int j = 0; j < i && c3; ++j) {
            c2->next = c3;
            c2 = c2->next;
            c3 = c3->next;
        }
    }
    c1->next = nullptr;
    c2->next = nullptr;
}

void merge(int i) {
    ListNode * c3 = &t3;
    ListNode * c1 = t1.next;
    ListNode * c2 = t2.next;

    while (c1 || c2) {

        int n1 = 0;
        int n2 = 0;
        while (n1 < i && n2 < i && c1 && c2) {
            if (c1->val <= c2->val) {
                c3->next = c1;
                c1 = c1->next;
                n1 += 1;
            } else {
                c3->next = c2;
                c2 = c2->next;
                n2 += 1;
            }
            c3 = c3->next;
        }
        while (n1 < i && c1) {
            c3->next = c1;
            c1 = c1->next;
            c3 = c3->next;
            n1 += 1;
        }
        while (n2 < i && c2) {
            c3->next = c2;
            c2 = c2->next;
            c3 = c3->next;
            n2 += 1;
        }
    }
    c3->next = nullptr;
}


ListNode* sortList(ListNode* head) {
    
    t1.next = nullptr;
    t2.next = nullptr;
    t3.next = head;
    int len = get_len(head);

    for (int i = 1; i < len; i *= 2) {
        split(i);
        merge(i);
    }
    return t3.next;
}
