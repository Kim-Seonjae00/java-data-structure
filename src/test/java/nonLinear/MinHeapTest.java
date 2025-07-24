package nonLinear;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinHeapTest {

    private MinHeap heap;

    @BeforeEach
    public void setUp() {
        heap = new MinHeap();
    }

    @Test
    public void testInsertAndSize() {
        assertEquals(0, heap.size());
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        assertEquals(3, heap.size());
    }

    @Test
    public void testExtractMin() throws Exception {
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(3);

        assertEquals(3, heap.extractMin());
        assertEquals(5, heap.extractMin());
        assertEquals(10, heap.extractMin());
        assertEquals(20, heap.extractMin());
        assertEquals(0, heap.size());

        Exception exception = assertThrows(Exception.class, () -> {
            heap.extractMin();
        });
        assertEquals("Heap is empty", exception.getMessage());
    }

    @Test
    public void testInsertAndExtractMixed() throws Exception {
        heap.insert(15);
        assertEquals(15, heap.extractMin());

        heap.insert(10);
        heap.insert(5);
        assertEquals(5, heap.extractMin());
        assertEquals(10, heap.extractMin());
    }
}
