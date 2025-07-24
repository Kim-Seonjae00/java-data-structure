package linear;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {

    // 스택에 요소를 넣고 뺄 때 정상 동작하는지 테스트
    @Test
    public void testPushAndPop() throws Exception {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        assertTrue(stack.isEmpty());  // 초기에는 비어 있어야 함

        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size()); // 요소가 2개 있어야 함

        assertEquals(20, stack.pop()); // 마지막에 넣은 20이 먼저 나와야 함
        assertEquals(1, stack.size()); // 하나 남음

        assertEquals(10, stack.pop()); // 그 다음 10이 나와야 함
        assertTrue(stack.isEmpty());   // 다시 비어야 함
    }

    // 스택이 꽉 찼을 때 예외 발생하는지 테스트
    @Test
    public void testStackOverflow() {
        ArrayStack<Integer> stack = new ArrayStack<>(2);
        Exception exception = assertThrows(Exception.class, () -> {
            stack.push(1);
            stack.push(2);
            stack.push(3);  // 3번째 넣으려 하면 예외 발생
        });
        assertEquals("Stack Overflow", exception.getMessage());
    }

    // 스택이 비었을 때 pop 시 예외 발생하는지 테스트
    @Test
    public void testStackUnderflow() {
        ArrayStack<Integer> stack = new ArrayStack<>(2);
        // 빈 스택에서 pop 시 예외 발생
        Exception exception = assertThrows(Exception.class, stack::pop);
        assertEquals("Stack Underflow", exception.getMessage());
    }
}
