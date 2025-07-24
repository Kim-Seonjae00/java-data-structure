package linear;

public class SinglyLinkedList<T> {
    //단일 연결 리스트
    //노드들이 한 방향으로 연결된 리스트 구조
    //배열과 다르게 크기 제한이 없으며, 삽입/삭제가 유연함.
    //임의 접근은 불가하여 탐색은 순차적으로 진행

    private class Node {
        T data;      // 노드가 저장하는 데이터
        Node next;   // 다음 노드 참조

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;  // 리스트의 첫 노드
    private int size;   // 리스트 크기

    public SinglyLinkedList() {
        head = null;  // 빈 리스트는 head가 null
        size = 0;
    }

    // 리스트 맨 앞에 노드 추가
    public void addFirst(T data) {
        Node newNode = new Node(data);  // 새 노드 생성
        newNode.next = head;            // 새 노드의 다음은 기존 head
        head = newNode;                 // head가 새 노드를 가리킴
        size++;
    }

    // 리스트 맨 뒤에 노드 추가
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {  // 리스트가 비었으면 새 노드가 head
            head = newNode;
        } else {
            Node curr = head;
            // 마지막 노드 찾기 (next가 null인 노드)
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;  // 마지막 노드의 다음에 새 노드 연결
        }
        size++;
    }

    // 리스트 맨 앞 노드 삭제 후 데이터 반환
    public T removeFirst() throws Exception {
        if (head == null) {
            throw new Exception("List is empty");
        }
        T data = head.data;  // 삭제할 노드 데이터 저장
        head = head.next;    // head를 다음 노드로 변경 (삭제 효과)
        size--;

        return data;
    }

    // 리스트 임의 위치 삭제 후 데이터 반환
    public T removeAt(int index) throws Exception {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();

        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node target = prev.next;
        prev.next = target.next;  // prev 노드가 target 다음 노드를 가리키도록 변경
        size--;

        return target.data;
    }

    // 리스트 크기 반환
    public int size() {
        return size;
    }

    // 리스트가 비었는지 확인
    public boolean isEmpty() {
        return size == 0;
    }
}
