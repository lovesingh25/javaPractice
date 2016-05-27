package trialjava;

import java.util.LinkedList;
import java.util.Queue;

public class binarySearchTree {
	static int inorder[] = {4, 2, 5, 1, 6, 3};
	static int preorder[] = {1, 2, 4, 5, 3, 6};
	static int preindex = 0;
			//hello
	Node root;
	Node prev;
	binarySearchTree(){
		root = null;
	}

	 public static void main(String[] args)
	    {
		 
		 binarySearchTree tree = new binarySearchTree();
		 int i = 1;
		 while(i<5){
			 tree.root = tree.insertNode(tree.root, i*10);
			 i++;
		 }
		 tree.insertNode(tree.root, 50);
		 tree.insertNode(tree.root, 4);
		 tree.insertNode(tree.root, 15);
		 //tree.root.left.right  = new Node(3);
		 if(tree.isBST(tree)){
		 tree.printInorder(tree.root);
		 }
		 /* 
		 depthSearch(tree);	 
		 System.out.println(maxdepth(tree.root) + 1);
		 tree.root = tree.createTree(0,inorder.length-1); 	
		 tree.printInorder(tree.root);
		 System.out.println();
		 tree.width(tree);
		 tree.printAncestor(tree.root,8);
		 */
	    }

	private static Node createTree(int start, int end) {
		if (start > end) {
			return null;
		}
		Node actual = null;
		if (preindex < preorder.length) {
			actual = new Node(preorder[preindex++]);
		}
		/* If this node has no children then return */
		if (start == end) {
			return actual;
		}
		int inIndex = 0;
		for (int i = start; i < end; i++) {
			if (actual != null && actual.data == inorder[i]) {
				inIndex = i;
				break;
			}
		}
		if (actual != null) {
			//System.out.println("start "+start+"index "+inIndex+"end "+end+"data "+actual.data);
			actual.left = createTree(start, inIndex - 1);
			actual.right = createTree(inIndex + 1, end);
		}
		return actual;
	}

	private static int maxdepth(Node root) {

		if (root == null) {
			return 0;
		}
		int l = maxdepth(root.left);
		int r = maxdepth(root.right);

		if (l > r) {
			return (l + 1);
		} else {
			return (r + 1);
		}
	}

	 public int numberOfNode(Node root){
		 if(root == null){
			 return 0;
		 }
		 return 1+(numberOfNode(root.left))+(numberOfNode(root.right));
	 }

	 public Boolean isBST(binarySearchTree tree){
		 prev = null;
		 return BSTorNot(tree.root);
	 }

	 Boolean BSTorNot(Node root){
		 if (root != null) {

			if(!BSTorNot(root.left)){
				return false;
			}
			if(prev != null && prev.data > root.data){
				return false;
			}
			prev = root;

			 return BSTorNot(root.right);
		}
		return true;

	 }

	public void deleteNode(binarySearchTree tree,int key){

	}

	public Node insertNode(Node root , int key){
		if(root == null){
			root = new Node(key);
		}
		else if(key < root.data){
			root.left = insertNode( root.left ,  key);
		}
		else if(key > root.data){
			root.right = insertNode( root.right ,  key);
		}
		return root;
	 }

	public Node searchNode(Node root,int key){
		 if(root == null || root.data == key){
			 return root;
		 }
		 if(key > root.data){
			 return searchNode(root.right,key);
		 }
		 else{
			 return searchNode(root.left,key);
		 }

	}

	Boolean printAncestor(Node node,int key) {
	    	if(node == null){
	    		return false;
	    	}
	    	if(node.data == key){
	    		return true;
	    	}

		if(printAncestor(node.left,key) || printAncestor(node.right,key)){
	    		System.out.print(node.data + " ");
	            return true;
	    	}
			return false;
	    }

	/* This funtcion is here primeNumber to test buildTree() */
	void printInorder(Node node) {
	        if (node == null) {
	            return;
	        }

	        /* first recur on left child */
	        printInorder(node.left);

	        /* then print the data of node */
	        System.out.print(node.data + " ");

	        /* now recur on right child */
	        printInorder(node.right);
	    }

	private void depthSearch(binarySearchTree tree){
		 Queue<Node> q = new LinkedList();
		 Node temp = tree.root;
		 q.add(temp);
		 while(temp != null){
			 try{
				 temp =(Node)q.remove();
				 System.out.println(temp.data);
				 if(temp.left != null){
					 q.add(temp.left);
				 }
				if(temp.right != null){
					 q.add(temp.right);
				}		
			 }
			 catch(Exception E){
				 System.out.println("End of BFS");
				 temp = null;
			 }	 			
		 }
	 }
	private void width(binarySearchTree tree){
		 Queue<Node> q = new LinkedList();
		 Node temp = tree.root;
		 q.add(temp);
		 int count = 1;
		 while(!q.isEmpty()){
			 try{
				 int levelcount = 0;				
				 while(count > 0){
					 temp =(Node)q.remove();
					 //System.out.print(temp.data+" ");
					 if(temp.left != null){
						 levelcount++;
						 q.add(temp.left);
					 }
					if(temp.right != null){
						levelcount++;
						 q.add(temp.right);
					}	
					count--;
				 }
				 count = levelcount;
				 System.out.println(count);
			 }
			 
			 catch(Exception E){
				 count = 0;
				 System.out.println("End of BFS");
				 temp = null;
			 }	 			
		 }
	 }
}