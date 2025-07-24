package nonLinear;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    private BinarySearchTree tree;

    @BeforeEach
    public void setUp() {
        tree = new BinarySearchTree();
        // 기본 트리 구성
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
    }

    @Test
    public void testSearchExisting() {
        assertTrue(tree.search(50));
        assertTrue(tree.search(20));
        assertTrue(tree.search(80));
    }

    @Test
    public void testSearchNonExisting() {
        assertFalse(tree.search(25));
        assertFalse(tree.search(90));
    }

    @Test
    public void testInsertAndSearch() {
        tree.insert(25);
        assertTrue(tree.search(25));
    }

    @Test
    public void testDeleteLeafNode() {
        assertTrue(tree.search(20));
        tree.delete(20);
        assertFalse(tree.search(20));
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        tree.insert(65);
        assertTrue(tree.search(60));
        tree.delete(60);
        assertFalse(tree.search(60));
        assertTrue(tree.search(65));
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        assertTrue(tree.search(50));
        tree.delete(50);
        assertFalse(tree.search(50));
    }

    @Test
    public void testInorderTraversal() {
        // 중위 순회 결과가 오름차순 정렬된 리스트가 됨
        // 순회를 출력 대신 배열이나 리스트로 받아오도록 메서드를 수정하면 좋지만,
        // 여기선 출력 대신 성공적으로 호출되는지 확인만 함
        tree.inorder();
    }

    @Test
    public void testPreorderTraversal() {
        tree.preorder();
    }

    @Test
    public void testPostorderTraversal() {
        tree.postorder();
    }
}
