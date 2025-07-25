package nonLinear;

import java.util.BitSet;
import java.util.Random;

//확률적인 자료구조로 어떠한 원소가 집합에 존재할 가능성을 빠르고 효율적으로 검사함
//없다는 것은 100% 확실하지만 있다는 것은 확실하지 않음.
//블룸 필터 : n개의 해시함수와 1개의 Array로 구성
//          해시함수 : 원소에 값을 Array Index의 값으로 바꿔줌.
//          n개의 해시함수 : 각 함수마다 해시 기법이 다름
//          해시함수의 갯수 : 해시 함수가 많으면 "있다"의 신뢰성이 향상, 다만 계산비용이 증가하며 비트배열이 빠르게 포화됨.
//                        일반적으로 n = m/n * ln2 (m:비트 크기, n:원소의 수)
//                        비트 배열의 크기 m = - n*ln(p) / (ln2)^2   (n:예상 원소 수, p:허용하는 거짓 양성 확률)
//원소 추가 시, 여러 해시 함수로 나온 인덱스들의 비트 배열을 1로 설정
//원소 검사 시, 모드 해시 함수 결과 위치가 1이면 "있을 가능성", 하나라도 0이면 확실히 없음.
//CDN, Key Value Store에 사용됨.

public class BloomFilter {
    private final BitSet bitset;          // 비트 배열: 원소 존재 여부를 비트로 표시
    private final int size;               // 비트 배열 크기
    private final int[] hashSeeds;        // 각 해시 함수에 사용할 시드 값들

    // 생성자: 비트 배열 크기와 해시 함수 개수 지정
    public BloomFilter(int size, int hashFunctionsCount) {
        this.size = size;
        this.bitset = new BitSet(size);
        this.hashSeeds = new int[hashFunctionsCount];

        Random rand = new Random();
        // 각 해시 함수마다 다른 시드값 생성 (랜덤 정수)
        for (int i = 0; i < hashFunctionsCount; i++) {
            hashSeeds[i] = rand.nextInt();
        }
    }

    // 해시 함수: 입력 문자열과 시드를 받아 해시값 생성
    // 여러 해시 함수를 시뮬레이션하기 위해 시드값을 곱해서 다양성 부여
    private int hash(String key, int seed) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash = seed * hash + c;
        }
        // 음수 방지 및 비트 배열 크기로 나눠 인덱스 반환
        return Math.abs(hash) % size;
    }

    // 원소 추가: 여러 해시 함수 결과에 해당하는 비트들을 1로 설정
    public void add(String key) {
        for (int seed : hashSeeds) {
            int index = hash(key, seed);
            bitset.set(index);  // 해당 인덱스 비트 1로 설정
        }
    }

    // 원소 존재 여부 검사
    // 모든 해시 함수 결과 인덱스가 1이면 '존재할 가능성 있음'
    // 하나라도 0이면 '존재하지 않음'
    public boolean contains(String key) {
        for (int seed : hashSeeds) {
            int index = hash(key, seed);
            if (!bitset.get(index)) {  // 하나라도 0이면 확실히 없음
                return false;
            }
        }
        return true;  // 모두 1이면 있을 가능성 있음 (거짓 양성 가능)
    }
}
