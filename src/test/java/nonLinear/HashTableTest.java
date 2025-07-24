package nonLinear;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    public void testPutAndGet() {
        HashTable<String, Integer> table = new HashTable<>(10);

        table.put("apple", 100);
        table.put("banana", 200);

        assertEquals(100, table.get("apple"));
        assertEquals(200, table.get("banana"));
        assertNull(table.get("orange")); // 없는 키는 null 반환 예상
    }

    @Test
    public void testOverwriteValue() {
        HashTable<String, String> table = new HashTable<>(5);

        table.put("key1", "value1");
        table.put("key1", "value2");  // 기존 값 덮어쓰기

        assertEquals("value2", table.get("key1"));
    }

    @Test
    public void testRemove() {
        HashTable<Integer, String> table = new HashTable<>(5);

        table.put(1, "one");
        table.put(2, "two");

        assertTrue(table.remove(1));
        assertNull(table.get(1));
        assertEquals(1, table.size());

        assertFalse(table.remove(10)); // 없는 키 삭제 시 false 반환
    }

    @Test
    public void testContainsKey() {
        HashTable<String, Integer> table = new HashTable<>(5);

        table.put("a", 1);
        table.put("b", 2);

        assertTrue(table.containsKey("a"));
        assertFalse(table.containsKey("c"));
    }

    @Test
    public void testSizeAndEmpty() {
        HashTable<String, Integer> table = new HashTable<>(5);

        assertEquals(0, table.size());

        table.put("x", 10);
        table.put("y", 20);

        assertEquals(2, table.size());
    }
}
