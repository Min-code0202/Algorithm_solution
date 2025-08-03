import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        final int N = 1_000_000; // 테스트 횟수 (100만번)
        
        Stack<String> stack = new Stack<>();
        CustomStack cStack = new CustomStack();

        long start, end;

        // ====== 1. push 성능 테스트 ======
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            stack.push("data" + i);
        }
        end = System.nanoTime();
        System.out.println("Java Stack push: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            cStack.push("data" + i);
        }
        end = System.nanoTime();
        System.out.println("CustomStack push: " + (end - start) / 1_000_000.0 + " ms");


        // ====== 2. peek 성능 테스트 ======
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            stack.peek();
        }
        end = System.nanoTime();
        System.out.println("Java Stack peek: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            cStack.peek();
        }
        end = System.nanoTime();
        System.out.println("CustomStack peek: " + (end - start) / 1_000_000.0 + " ms");


        // ====== 3. pop 성능 테스트 ======
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            stack.pop();
        }
        end = System.nanoTime();
        System.out.println("Java Stack pop: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            cStack.pop();
        }
        end = System.nanoTime();
        System.out.println("CustomStack pop: " + (end - start) / 1_000_000.0 + " ms");
    }
}
