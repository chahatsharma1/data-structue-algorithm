import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {

        if (queue1.isEmpty()) {
            return 0;
        }
        while (queue1.size() > 1){
            queue2.add(queue1.remove());
        }

        int removed = queue1.remove();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return removed;
    }

    public int top() {
        while (queue1.size() > 1){
            queue2.add(queue1.remove());
        }
        int top = 0;
        if (queue1.peek() != null){
            top = queue1.peek();
        }

        queue2.add(queue1.remove());

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
