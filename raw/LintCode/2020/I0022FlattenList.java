package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*

    描述
    给定一个列表，该列表中的每个元素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。

    如果给定的列表中的要素本身也是一个列表，那么它也可以包含列表。

    您在真实的面试中是否遇到过这个题？  
    样例
    样例  1:
        输入: [[1,1],2,[1,1]]
        输出:[1,1,2,1,1] 
        
        样例解释:
        将其变成一个只包含整数的简单列表。


    样例 2:
        输入: [1,2,[1,2]]
        输出:[1,2,1,2]
        
        样例解释: 
        将其变成一个只包含整数的简单列表。
        
    样例 3:
        输入:[4,[3,[2,[1]]]]
        输出:[4,3,2,1]
        
        样例解释: 
        将其变成一个只包含整数的简单列表。

*/


public class I0022FlattenList {

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        Stack<NestedInteger> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        push(s, nestedList);

        while (!s.isEmpty()) {
            NestedInteger x = s.pop();
            if (x.isInteger()) ans.add(x.getInteger());
            else push(s, x.getList());
        }
        return ans;
    }

    private void push(Stack<NestedInteger> s, List<NestedInteger> l) {
        for (int i = l.size() - 1; i >= 0; i--) {
            s.push(l.get(i));
        }
    }
}
