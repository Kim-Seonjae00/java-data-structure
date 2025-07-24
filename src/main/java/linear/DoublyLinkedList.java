package linear;

public class DoublyLinkedList<T> {

    // 리스트 노드 클래스 (내부 클래스)
    private class Node {
        T data;       // 노드가 저장하는 데이터
        Node prev;    // 이전 노드 참조
        Node next;    // 다음 노드 참조

        // 노드 생성자: 데이터 초기화, 이전과 다음은 null로 시작
        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;  // 리스트의 첫 번째 노드
    private Node tail;  // 리스트의 마지막 노드
    private int size;   // 리스트 크기(노드 개수)

    // 생성자: 빈 리스트 초기화
    public DoublyLinkedList() {
        head = null;    // 처음엔 헤드 없음
        tail = null;    // 처음엔 테일 없음
        size = 0;       // 크기 0
    }

    // 리스트 맨 앞에 데이터 추가
    public void addFirst(T data) {
        Node newNode = new Node(data);  // 새 노드 생성
        if (head == null) {             // 리스트가 비어 있으면
            head = tail = newNode;      // 새 노드가 헤드이자 테일
        } else {
            newNode.next = head;        // 새 노드의 다음은 기존 헤드
            head.prev = newNode;        // 기존 헤드의 이전은 새 노드
            head = newNode;             // 헤드를 새 노드로 변경
        }
        size++;                         // 크기 1 증가
    }

    // 리스트 맨 뒤에 데이터 추가
    public void addLast(T data) {
        Node newNode = new Node(data);  // 새 노드 생성
        if (tail == null) {             // 리스트가 비어 있으면
            head = tail = newNode;      // 새 노드가 헤드이자 테일
        } else {
            tail.next = newNode;        // 기존 테일의 다음은 새 노드
            newNode.prev = tail;        // 새 노드의 이전은 기존 테일
            tail = newNode;             // 테일을 새 노드로 변경
        }
        size++;                         // 크기 1 증가
    }

    // 리스트 맨 앞 노드 삭제 및 데이터 반환
    public T removeFirst() throws Exception {
        if (head == null)                // 리스트가 비어 있으면 예외 발생
            throw new Exception("List is empty");

        T data = head.data;              // 삭제할 데이터 저장
        head = head.next;                // 헤드를 다음 노드로 이동

        if (head != null)                // 새 헤드가 존재하면 이전 노드 참조 제거
            head.prev = null;
        else                            // 새 헤드가 없으면 리스트가 빈 상태, 테일도 null
            tail = null;

        size--;                         // 크기 1 감소

        return data;                    // 삭제한 데이터 반환
    }

    // 리스트 맨 뒤 노드 삭제 및 데이터 반환
    public T removeLast() throws Exception {
        if (tail == null)                // 리스트가 비어 있으면 예외 발생
            throw new Exception("List is empty");

        T data = tail.data;              // 삭제할 데이터 저장
        tail = tail.prev;                // 테일을 이전 노드로 이동

        if (tail != null)                // 새 테일이 존재하면 다음 노드 참조 제거
            tail.next = null;
        else                            // 새 테일이 없으면 리스트가 빈 상태, 헤드도 null
            head = null;

        size--;                         // 크기 1 감소

        return data;                    // 삭제한 데이터 반환
    }

    // 임의 위치(index)의 노드 삭제 및 데이터 반환
    public T removeAt(int index) throws Exception {
        if (index < 0 || index >= size)  // 인덱스 범위 체크
            throw new IndexOutOfBoundsException();

        if (index == 0)                   // 첫 노드 삭제
            return removeFirst();

        if (index == size - 1)            // 마지막 노드 삭제
            return removeLast();

        Node curr = head;                 // 삭제할 노드를 찾기 위해 헤드부터 탐색
        for (int i = 0; i < index; i++) {
            curr = curr.next;             // 인덱스 위치까지 이동
        }

        // 삭제할 노드의 이전 노드가 다음 노드를 가리키도록 연결
        curr.prev.next = curr.next;
        // 삭제할 노드의 다음 노드가 이전 노드를 가리키도록 연결
        curr.next.prev = curr.prev;

        size--;                         // 크기 1 감소

        return curr.data;               // 삭제한 데이터 반환
    }

    // 리스트 크기 반환
    public int size() { return size; }

    // 리스트가 비었는지 여부 반환
    public boolean isEmpty() { return size == 0; }
}
