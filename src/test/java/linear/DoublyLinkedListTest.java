package linear;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    // addFirst와 removeFirst 기본 동작 테스트
    @Test
    public void testAddFirstAndRemoveFirst() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());  // 리스트가 비어 있어야 함

        list.addFirst(10);
        list.addFirst(20);
        assertEquals(2, list.size());  // 노드가 2개 있어야 함

        assertEquals(20, list.removeFirst());  // 첫 번째 노드 삭제
        assertEquals(1, list.size());           // 노드 하나 남음

        assertEquals(10, list.removeFirst());  // 다음 노드 삭제
        assertTrue(list.isEmpty());             // 리스트 비어야 함
    }

    // addLast 테스트
    @Test
    public void testAddLast() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        assertEquals(2, list.size());  // 노드가 2개 있어야 함
    }

    // removeLast 테스트
    @Test
    public void testRemoveLast() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(10);
        list.addLast(20);

        assertEquals(20, list.removeLast());  // 마지막 노드 삭제
        assertEquals(1, list.size());          // 노드 하나 남음

        assertEquals(10, list.removeLast());  // 다음 노드 삭제
        assertTrue(list.isEmpty());            // 리스트 비어야 함
    }

    // removeAt 테스트 (중간 노드 삭제)
    @Test
    public void testRemoveAt() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(20, list.removeAt(1));  // 인덱스 1 노드 삭제
        assertEquals(2, list.size());         // 노드 2개 남음

        assertEquals(10, list.removeAt(0));  // 인덱스 0 노드 삭제
        assertEquals(1, list.size());         // 노드 1개 남음

        assertEquals(30, list.removeAt(0));  // 마지막 노드 삭제
        assertTrue(list.isEmpty());           // 리스트 비어야 함
    }

    // 예외 테스트: 빈 리스트에서 removeFirst 호출 시
    @Test
    public void testRemoveFirstOnEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Exception exception = assertThrows(Exception.class, list::removeFirst);
        assertEquals("List is empty", exception.getMessage());
    }

    // 예외 테스트: 빈 리스트에서 removeLast 호출 시
    @Test
    public void testRemoveLastOnEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Exception exception = assertThrows(Exception.class, list::removeLast);
        assertEquals("List is empty", exception.getMessage());
    }

    // 예외 테스트: 유효하지 않은 인덱스에 removeAt 호출 시
    @Test
    public void testRemoveAtInvalidIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Exception exception = assertThrows(IndexOutOfBoundsException.class,  () -> {
            list.removeAt(0);
        });
        assertNotNull(exception);
    }
}
