<h1>자바 구현 자료구조 스터디</h1>
<p>main - 자료구조 구현 클래스<br>
test - 클래스 테스트 (JUnit 사용)</p>

<pre>
선형(linear)<br>
  -. ArrayStack : LIFO(후입선출) 구조로, 마지막에 삽입한 요소를 먼저 꺼냄<br>
  -. SinglyLinkedList : 단방향 연결 리스트로, 각 노드는 다음 노드의 주소만 가짐<br>
  -. DoublyLinkedList : 양방향 연결 리스트로, 앞뒤 노드 모두 참조 가능<br>
  -. LinkedQueue : FIFO(선입선출) 큐 구조로, 연결 리스트로 구현하여 유연한 크기 관리
</pre>

<pre>
비선형(nonLinear)<br>
  -. BinarySearchTree : 정렬된 이진 트리로, 탐색, 삽입, 삭제가 평균 O(log n)<br>
  -. BloomFilter : 확률적 자료구조로, 빠른 원소 존재 여부 검사와 공간 효율성<br>
  -. HashTable : 키-값 쌍 저장, 해시 함수를 이용해 평균 O(1) 접근 시간 제공<br>
  -. MinHeap : 완전 이진 트리 기반 최소 힙으로, 최솟값을 빠르게 추출 가능
</pre>
