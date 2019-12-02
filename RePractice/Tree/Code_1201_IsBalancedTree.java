package RePractice.Tree;

public class Code_1201_IsBalancedTree {
	public static class Node{
		private int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static class ReturnData{
		private boolean isB;
		private int h;

		public ReturnData(boolean isB, int h) {
			this.isB = isB;
			this.h = h;
		}
	}

	public static boolean isBB(Node node){
		return processs(node).isB;
	}

	public static ReturnData processs(Node node){
		if (node == null){
			return new ReturnData(false,0);
		}
		ReturnData leftData = processs(node.left);
		if (!leftData.isB){
			return new ReturnData(false,0);
		}

		ReturnData rightData = processs(node.right);
		if (!rightData.isB){
			return new ReturnData(false,0);
		}

		if (Math.abs(leftData.h - rightData.h) > 1 ){
			return new ReturnData(false,0);
		}

		return new ReturnData(true,Math.max(leftData.h,rightData.h) + 1);
	}






















	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}

	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, res);
		if (!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));

	}

}
