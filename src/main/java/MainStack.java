import util.Stack;

public class MainStack {
    public static void main(String[] args) {
        Stack<Integer> head = new util.Stack<Integer>();
        System.out.println("Stack init\t" + head);

        head.push(1);
        head.push(2);
        head.push(3);
        System.out.println("Adding elements 1, 2 and 3\t" + head);

        head.pop();
        System.out.println("Pop last\t" + head);
        head.pop();
        System.out.println("Pop last\t" + head);

        System.out.println("Top element is\t" + head.top().value());

        Object[] stackArr = head.toArray();
        System.out.print("Stack to array\t");
        for (int i = stackArr.length - 1; i >= 0; i--) {
            System.out.print(stackArr[i] + " ");
        }
    }
}