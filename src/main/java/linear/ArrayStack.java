package linear;

public class ArrayStack<T> {
    //Stack은 LIFO(Last-In First-Out)구조

    private final T[] stack;     // 스택 데이터를 저장할 배열
    private int top;       // 스택의 가장 위 위치 인덱스
    private final int capacity;  // 스택 최대 용량

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        // 제네릭 배열 생성: Object 배열을 T 배열로 캐스팅
        stack = (T[]) new Object[capacity];
        top = -1;  // 스택이 비어있을 때 top은 -1
    }

    // 스택에 데이터 추가
    public void push(T item) throws Exception {
        // 스택이 꽉 찼으면 예외 발생
        if (top == capacity - 1) {
            throw new Exception("Stack Overflow");
        }
        stack[++top] = item;  // top을 1 증가시키고 데이터를 저장
    }

    // 스택에서 데이터 꺼내기
    public T pop() throws Exception {
        // 스택이 비어있으면 예외 발생
        if (top == -1) {
            throw new Exception("Stack Underflow");
        }
        T item = stack[top];  // top 위치 데이터 저장
        stack[top--] = null;  // 참조 해제(메모리 누수 방지) 후 top 감소

        return item;          // 꺼낸 데이터 반환
    }

    // 스택에서 가장 위 데이터를 확인만 함 (삭제하지 않음)
    public T peek() throws Exception {
        if (top == -1) {
            throw new Exception("Stack is empty");
        }

        return stack[top];
    }

    // 스택이 비었는지 확인
    public boolean isEmpty() {
        return top == -1;
    }

    // 스택에 저장된 데이터 개수 반환
    public int size() {
        return top + 1;
    }
}