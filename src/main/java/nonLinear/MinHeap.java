package nonLinear;

import java.util.ArrayList;

//힙 : 완전 이진 트리의 일종, 부모노드가 자식 노드보다 항상 작거나 같은(최소 힙) 혹은 크거나 같은(최대 힙) 성질을 가짐
//보통 힙은 최솟값(최대값)을 효울적으로 관리하기 위해 사용.
//최소 힙 : 루트 노드가 가장 작은 값을 가짐, 새로운 값 추가 시 트리의 마지막 위치에 삽입.
//        부모와 비교하며 위치를 조정 -> 루트 노드 제거 시 마지막 노드를 루트로 옮김
//현재 최소 힙으로 구현되어 있으나 최대 힙은 비교 연산을 바꾸면 최대 힙 구현 가능.

public class MinHeap {
    private final ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // 값 삽입 (push 연산)
    public void insert(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        // 부모와 비교하며 위치 조정
        while (i != 0 && heap.get(parent(i)) > heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // 루트(최소값) 반환 및 제거(pop 연산)
    public int extractMin() throws Exception {
        if (heap.isEmpty())
            throw new Exception("Heap is empty");

        int root = heap.getFirst();
        int lastVal = heap.removeLast();

        if (!heap.isEmpty()) {
            heap.set(0, lastVal);
            heapify(0);
        }

        return root;
    }

    // 힙 재정렬(재귀적 아래로 이동)
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < heap.size() && heap.get(left) < heap.get(smallest))
            smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest))
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int size() {
        return heap.size();
    }
}
