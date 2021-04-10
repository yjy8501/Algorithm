package binary_search_tree;

public class binary_search_tree {

	// 루트노드 필드
	private node root;

	// 루트노드 null로 초기화
	public binary_search_tree() {
		root = null;
	}

	// private 노드 클래스
	private class node {

		// 노드 필드
		String key;
		node leftchild;
		node rightchild;

		// 노드 생성자
		public node() {
			this.key = null;
			this.leftchild = null;
			this.rightchild = null;
		}

	}

	// add 매소드
	public void add(String insert_Key) {
		root = insert_tree(root, insert_Key);
	}

	// 트리에 노드 삽입
	public node insert_tree(node r, String insert_Key) {

		// 노드가 null 이면 새로 노드를 생성 후 리턴
		if (r == null) {
			node newNode = new node();
			newNode.key = insert_Key;
			return newNode;
		}

		// 삽입값이 노드 값보다 작을 때
		else if (insert_Key.compareToIgnoreCase(r.key) < 0) {
			r.leftchild = insert_tree(r.leftchild, insert_Key);
			return r;
		}

		// 삽입값이 노드 값과 같을 때
		else if (insert_Key.compareToIgnoreCase(r.key) == 0) {
			return r;
		}

		// 삽입값이 노드 값보다 클 때
		else {
			r.rightchild = insert_tree(r.rightchild, insert_Key);
			return r;
		}

	}

	// printTree 메소드
	public void printTree() {
		inorder(root);
	}

	// 트리 중위순회 메소드
	private void inorder(node r) {

		if (r != null) {

			inorder(r.leftchild);
			System.out.print(" " + r.key);
			inorder(r.rightchild);
		}

	}

	// 메인 클래스
	public static void main(String[] args) {

		binary_search_tree tree = new binary_search_tree();

		System.out.print("hw6_1 : 양재용");

		// tree를 중순위 순회하여 출력
		System.out.print("\n오름차순 출력 =");
		tree.printTree();

		// tree에 다음과 같이 1개의 단어를 삽입한 후 tree를 중순위 순회하여 출력
		tree.add("cat");
		System.out.print("\n오름차순 출력 =");
		tree.printTree();

		// tree에 다음과 같이 13개의 단어를 추가로 삽입한 후 tree를 중순위 순회하여 출력
		tree.add("HAT");
		tree.add("ant");
		tree.add("BEE");
		tree.add("dog");
		tree.add("Last");
		tree.add("KEY");
		tree.add("Korea");
		tree.add("egg");
		tree.add("ink");
		tree.add("juice");
		tree.add("free");
		tree.add("go");
		tree.add("CAT"); // 이미 존재하므로 삽입 x

		System.out.print("\n오름차순 출력 =");
		tree.printTree();

	}

}
