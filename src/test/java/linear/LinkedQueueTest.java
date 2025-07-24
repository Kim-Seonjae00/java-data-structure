package linear;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {

    // enqueue, dequeue 기본 동작 테스트
    @Test
    public void testEnqueueAndDequeue() throws Exception {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        assertTrue(queue.isEmpty());  // 초기에는 비어 있어야 함

        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());  // 큐에 2개 데이터 있어야 함

        assertEquals(10, queue.dequeue());  // 먼저 들어온 10부터 나와야 함
        assertEquals(1, queue.size());      // 1개 남음

        assertEquals(20, queue.dequeue());  // 다음 데이터 삭제
        assertTrue(queue.isEmpty());         // 큐 다시 비어야 함
    }

    // 빈 큐에서 dequeue 호출 시 예외 발생 테스트
    @Test
    public void testDequeueOnEmpty() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        Exception exception = assertThrows(Exception.class, queue::dequeue);
        assertEquals("Queue is empty", exception.getMessage());
    }
}
