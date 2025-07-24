package linear;

public class LinkedQueue <T>{
    //큐는 FIFO(First-In First-Out)구조
    //단일 연결 리스트를 사용하면 큐의 앞(front)와 뒤(rear)를 관리하며 구현 가능

    // 내부 Node 클래스: 큐의 각 노드 역할
    private class Node {
        T data;       // 노드 데이터
        Node next;    // 다음 노드 참조

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;  // 큐의 앞쪽 노드
    private Node rear;   // 큐의 뒤쪽 노드
    private int size;    // 큐 크기

    public LinkedQueue() {
        front = null;  // 빈 큐는 front, rear 모두 null
        rear = null;
        size = 0;
    }

    // 큐 뒤쪽에 데이터 추가
    public void enqueue(T data) {
        Node newNode = new Node(data);
        if (rear == null) {     // 큐가 비어있으면
            front = rear = newNode;
        } else {
            rear.next = newNode;  // 기존 rear의 다음 노드로 연결
            rear = newNode;       // rear를 새 노드로 갱신
        }
        size++;
    }

    // 큐 앞쪽에서 데이터 삭제 및 반환
    public T dequeue() throws Exception {
        if (front == null) {
            throw new Exception("Queue is empty");
        }
        T data = front.data;     // 삭제할 데이터 저장
        front = front.next;      // front를 다음 노드로 변경
        if (front == null) {     // 만약 큐가 비면 rear도 null 처리
            rear = null;
        }
        size--;

        return data;
    }

    // 큐 크기 반환
    public int size() {
        return size;
    }

    // 큐가 비었는지 확인
    public boolean isEmpty() {
        return size == 0;
    }
}
