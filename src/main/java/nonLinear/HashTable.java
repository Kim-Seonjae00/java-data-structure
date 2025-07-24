package nonLinear;

import java.util.LinkedList;

//Key와 Value를 한 쌍으로 저장하는 자료구조
//Key를 해시값으로 변환하여 배열 인덱스를 결정
//각 인덱스(버킷)에 Key-value 쌍 저장
//충돌 시 체이닝(연결 리스트) 또는 오픈 어드레싱 방식으로 처리
//딕셔너리나 HashMap의 내부 구현체로도 사용됨

//* 해시충돌 : 서로 다른 키를 같은 배열 인덱스(버킷)으로 매핑하는 상황
//* 체이닝 방식 : 각 버킷을 연결리스트나 다른 자료구조로 구현 (이 클래스에선 체이닝방식 사용)
//* 오픈 어드레싱 : 충돌이 발생 시 빈 슬롯을 찾아서 다른 배열 위치에 저장
//              오픈 어드레싱 방식은 배열기반으로 메모리에 연속된 공간에
//              저장되어 cpu캐시 성능에 유리할수도 있다.
//              다만 배열 크기 조절 및 리사이징, 삭제연산처리가 복잡함 등의
//              이유로 구현이 까다롭다.

public class HashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Entry<K, V>>[] buckets;
    private final int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        buckets = new LinkedList[capacity];  // 각 버킷에 연결 리스트 초기화
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // 키의 해시값을 이용해 인덱스 계산
    private int getBucketIndex(K key) {
        //표준적인 방식 (modulo연산)
        return Math.abs(key.hashCode()) % capacity;
    }

    // 키-값 쌍 추가 혹은 갱신
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;  // 키가 존재하면 값 업데이트
                return;
            }
        }
        bucket.add(new Entry<>(key, value));  // 새 키-값 쌍 추가
        size++;
    }

    // 키에 해당하는 값 반환, 없으면 null
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;  // 키가 없으면 null 반환
    }

    // 키가 존재하는지 여부 반환
    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // 키에 해당하는 엔트리 삭제, 성공 시 true 반환
    public boolean remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return true;
            }
        }
        return false;
    }

    // 저장된 키-값 쌍 개수 반환
    public int size() {
        return size;
    }
}
