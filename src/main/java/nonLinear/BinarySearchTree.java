package nonLinear;

//이진탐색트리(BinarySearchTree, BST)
//왼쪽 자식은 부모보다 작고, 오른쪽 자식은 부모보다 큰 값

public class BinarySearchTree {
    // 노드 클래스: 트리의 기본 단위
    static class Node {
        int key;       // 저장하는 값
        Node left;     // 왼쪽 자식 노드
        Node right;    // 오른쪽 자식 노드

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root; // 트리의 루트 노드

    public BinarySearchTree() {
        root = null;
    }

    // 삽입 메서드 (외부 호출용)
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // 재귀적으로 노드 삽입하는 내부 메서드
    private Node insertRec(Node root, int key) {
        if (root == null) {             // 빈 자리 발견 시 새 노드 생성
            root = new Node(key);

            return root;
        }
        if (key < root.key)             // 작으면 왼쪽 서브트리로
            root.left = insertRec(root.left, key);
        else if (key > root.key)        // 크면 오른쪽 서브트리로
            root.right = insertRec(root.right, key);
        // 중복 키는 삽입하지 않음
        return root;
    }

    // 탐색 메서드 (외부 호출용)
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // 재귀 탐색
    private boolean searchRec(Node root, int key) {
        if (root == null) return false;       // 더 이상 노드 없으면 실패
        if (root.key == key) return true;     // 찾음
        if (key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    // 삭제 메서드 (외부 호출용)
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // 재귀적으로 삭제 처리
    private Node deleteRec(Node root, int key) {
        if (root == null) return null;

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // 삭제할 노드 발견

            // 1) 자식이 없거나 한쪽 자식만 있을 경우
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // 2) 두 자식이 모두 있을 경우
            // 오른쪽 서브트리에서 최소값(후계자) 찾기
            root.key = minValue(root.right);
            // 후계자 노드 삭제
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // 서브트리에서 최소값 찾기 (왼쪽 끝 노드)
    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            root = root.left;
            minv = root.key;
        }

        return minv;
    }

    // 중위 순회: 왼쪽 -> 현재 -> 오른쪽
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // 전위 순회: 현재 -> 왼쪽 -> 오른쪽
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // 후위 순회: 왼쪽 -> 오른쪽 -> 현재
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}
