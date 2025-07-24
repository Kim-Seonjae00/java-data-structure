package linear;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    // addFirst와 removeFirst 기본 동작 테스트
    @Test
    public void testAddFirstAndRemoveFirst() throws Exception {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertTrue(list.isEmpty());  // 초기에는 비어 있어야 함

        list.addFirst(10);
        list.addFirst(20);
        assertEquals(2, list.size());  // 노드 2개 있어야 함

        assertEquals(20, list.removeFirst());  // 가장 앞 노드부터 삭제되야 함
        assertEquals(1, list.size());           // 하나 남음

        assertEquals(10, list.removeFirst());  // 다음 노드 삭제
        assertTrue(list.isEmpty());             // 리스트 다시 비어야 함
    }

    // addLast 메서드로 리스트 끝에 데이터 추가하는 테스트
    @Test
    public void testAddLast() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        assertEquals(2, list.size());  // 노드 2개 있어야 함
    }

    // 빈 리스트에서 removeFirst 호출 시 예외 발생 테스트
    @Test
    public void testRemoveFirstOnEmpty() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Exception exception = assertThrows(Exception.class, list::removeFirst);
        assertEquals("List is empty", exception.getMessage());
    }
}
