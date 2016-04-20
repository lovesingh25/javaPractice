package trialjava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class verticalOrderTravesal {
	static HashMap hm;
	public static void main(String[] args) {
		hm = new HashMap();
		// TODO Auto-generated method stub
		binarySearchTree tree = new binarySearchTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
	    tree.root.left.right = new Node(5);
	    tree.root.right.left = new Node(6);
	    tree.root.right.right = new Node(7);
	    tree.root.right.left.right = new Node(8);
	    tree.root.right.right.right = new Node(9);
	    printVerticalTravesal(tree);
	}
	public static void printVerticalTravesal( binarySearchTree tree ){
		int i=0;
		actualTravesal(tree.root,i);
		int n = tree.numberOfNode(tree.root);
		for(int j = -n;j<n;j++){
			if(hm.containsKey(j)){
				System.out.println(hm.get(j));
			}
		}
	}
	private static Node actualTravesal(Node root,int i){
		if(root == null){
			return root;
		}
		actualTravesal(root.left,i-1);
		LinkedList l = null ;
		if(hm.containsKey(i)){
			l = (LinkedList) hm.get(i);
		}
		if(l != null){
			l.add(root.data);
		}
		else{
			hm.put(i , new LinkedList());
			l = (LinkedList) hm.get(i);
			l.add(root.data);
		}
		actualTravesal(root.right,i+1);		
		return root;
	}
}
