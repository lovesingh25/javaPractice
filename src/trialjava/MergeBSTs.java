package trialjava;

public class MergeBSTs {
	//correctBST method variables.
	static Node prev;
	static int storage;
	static Boolean swapped;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		binarySearchTree tree1 = new binarySearchTree();
		binarySearchTree tree2 = new binarySearchTree();
		tree1.root = new Node(7);
		tree1.root.left = new Node(5);
		tree1.root.right = new Node(2);
		tree2.root = new Node(4);
		tree2.root.left = new Node(1);
		tree2.root.right = new Node(10);
		//mergeBSTsAndsort(tree1.root,tree2.root);
		
		actualCorrectBst(tree1);
		tree1.printInorder(tree1.root);
		
	}
	static void actualCorrectBst(binarySearchTree tree1){
		swapped = true;
		while(swapped){
			swapped = false;
			prev = tree1.root;
			correctBST(tree1.root);
		}
	}
	static Node correctBST(Node root){
		if(root == null)
			return root;
		//inorder
		if(prev.data < root.data)
		prev = root;
		correctBST(root.left);
		
		if(prev.data > root.data){
			storage = prev.data;
			prev.data = root.data;
			root.data = storage;
			swapped = true;
		}
		correctBST(root.right);
		return null;
	}
	static Node mergeBSTsAndsort(Node root,Node root2){
		Node temp;
		if(root == null || root2 == null){
			return null;
		}
		if(root.data > root2.data){
			temp = mergeBSTsAndsort(root.left,root2);
		}
		else{
			temp = mergeBSTsAndsort(root,root2.left);
		}
		if(root.data < root2.data){
			System.out.println(root.data);
		}
		else{
			System.out.println(root2.data);
		}
		if(temp != null)
			System.out.println(temp.data);
		
		if(root.data < root2.data){
			temp = mergeBSTsAndsort(root.right,root2);
		}
		else{
			temp = mergeBSTsAndsort(root,root2.right);
		}
		return null;		
	}
}
