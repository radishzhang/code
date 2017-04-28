import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        boolean isOrder = false;
        int index = 0;
        int i = 0;
        if(pushA.length > 0 && popA.length > 0) {
            Stack<Integer> stack = new Stack<>();
            for (i = 0; i < popA.length; i++) {
                while(stack.isEmpty() || popA[i] != stack.peek()) {
                    if(index == pushA.length) {
                        break;
                    }
                    stack.push(pushA[index++]);
                }
                if(stack.peek() != popA[i]) {
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty() && i == popA.length) {
                isOrder = true;
            }
        }
        return isOrder;
    }
}
