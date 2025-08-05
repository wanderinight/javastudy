//package stack;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//
////Java标准库建议：
////优先使用Deque接口的ArrayDeque实现 避免使用遗留的Stack类
//public class StackConcrete {
//    /**
//     * 使用栈检查括号是否匹配
//     */
//    public boolean isBalanced(String expression) {
//        Deque<Character> stack = new ArrayDeque<>();
//        for (char c : expression.toCharArray()) {
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else if (c == ')' || c == ']' || c == '}') {
//                if (stack.isEmpty()) return false;
//                char top = stack.pop();
//                if (!((top == '(' && c == ')') ||
//                        (top == '[' && c == ']') ||
//                        (top == '{' && c == '}'))) {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
//
//    /**
//     * 计算后缀表达式 (逆波兰表达式)——————表达式求值、后缀表达式
//     */
//    public int evalRPN(String[] tokens) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (String token : tokens) {
//            if (token.equals("+")) {
//                stack.push(stack.pop() + stack.pop());
//            } else if (token.equals("-")) {
//                int b = stack.pop(), a = stack.pop();
//                stack.push(a - b);
//            } else if (token.equals("*")) {
//                stack.push(stack.pop() * stack.pop());
//            } else if (token.equals("/")) {
//                int b = stack.pop(), a = stack.pop();
//                stack.push(a / b);
//            } else {
//                stack.push(Integer.parseInt(token));
//            }
//        }
//        return stack.pop();
//    }
//
//    /**
//     * 使用栈实现图的非递归DFS
//     */
//    public void dfs(Node start) {
//        Deque<Node> stack = new ArrayDeque<>();
//        Set<Node> visited = new HashSet<>();
//
//        stack.push(start);
//        visited.add(start);
//
//        while (!stack.isEmpty()) {
//            Node current = stack.pop();
//            System.out.println(current); // 处理当前节点
//
//            for (Node neighbor : current.neighbors) {
//                if (!visited.contains(neighbor)) {
//                    visited.add(neighbor);
//                    stack.push(neighbor);
//                }
//            }
//        }
//    }
//}
////典型应用场景：
////函数调用栈
////括号匹配
////表达式求值
////回溯算法
////非递归DFS
