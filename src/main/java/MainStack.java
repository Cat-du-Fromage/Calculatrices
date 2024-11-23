import util.Stack;

public class MainStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Stack init\t" + stack);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Adding elements 1, 2 and 3\t" + stack);

        stack.pop();
        System.out.println("Pop last\t" + stack);
        stack.pop();
        System.out.println("Pop last\t" + stack);

        System.out.println("Top element is\t" + stack.top().value());

        Object[] stackArr = stack.toArray();
        System.out.print("Stack to array\t");
        for (int i = stackArr.length - 1; i >= 0; i--) {
            System.out.print(stackArr[i] + " ");
        }
    }
}