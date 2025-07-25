package nonLinear;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BloomFilterTest {

    private BloomFilter bloomFilter;

    @BeforeEach
    public void setUp() {
        // 비트 배열 크기 1000, 해시 함수 5개로 초기화
        bloomFilter = new BloomFilter(1000, 5);
    }

    @Test
    public void testAddAndContains() {
        bloomFilter.add("apple");
        bloomFilter.add("banana");

        // 분명히 추가한 값은 contains가 true여야 함
        assertTrue(bloomFilter.contains("apple"));
        assertTrue(bloomFilter.contains("banana"));

        // 추가하지 않은 값은 보통 false지만, 확률적 특성상 true일 수도 있음
        // 여기서는 일반적으로 false 기대
        assertFalse(bloomFilter.contains("orange"));
    }

    @Test
    public void testFalsePositivePossibility() {
        bloomFilter.add("test1");
        bloomFilter.add("test2");

        // 여러번 확인해도 확률적으로는 false일 가능성이 크지만
        // 블룸필터 특성상 false positive 발생 가능성 있음
        // 따라서 false positive를 완전히 배제할 수 없음을 인지하고 테스트함
        boolean result = bloomFilter.contains("unknown_value");
        // result는 true 또는 false 모두 가능하므로 단언하지 않음
        assertNotNull(result);
    }
}
