package trialjava;

public class leastCommonAncestor {
	static int k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binarySearchTree tree = new binarySearchTree();
		int i = 1;
		 while(i<5){
			 tree.root = tree.insertNode(tree.root, i*10);
			 i++;
		 }
		 tree.insertNode(tree.root, 50);
		 tree.insertNode(tree.root, 4);
		 tree.insertNode(tree.root, 1);
		 tree.insertNode(tree.root, 2);
		 tree.insertNode(tree.root, 3);
		 tree.insertNode(tree.root, 6);
		 tree.insertNode(tree.root, 7);
		 tree.insertNode(tree.root, 15);
		 //tree.printInorder(tree.root);
		 //findLeastCommon(tree.root,50,40);
		 //System.out.println(recfindLeastCommon(tree.root,50,40).data);
		 k=9;
		 System.out.println(findKsmallest(tree.root).data);
		 
		 
	}
	static void findLeastCommon(Node root,int key1 , int key2){
		while(root != null){
			if((root.data >= key1 && root.data <= key2) || 
					(root.data <= key1 && root.data >= key2)){
				System.out.println("The LCA = "+root.data);
				break;
			}
			else if(key1 < root.data && key2 < root.data){
				root = root.left;
			}
			else if(key1 > root.data && key2 > root.data){
				root = root.right;
			}			
		}
	}
	static Node recfindLeastCommon(Node root,int key1,int key2){
		if(root == null){
			return null;
		}
		if((root.data >= key1 && root.data <= key2) || 
				(root.data <= key1 && root.data >= key2)){
			return root;
		}
		else if(key1 < root.data && key2 < root.data){
			return recfindLeastCommon(root.left,key1,key2);
		}
		else if(key1 > root.data && key2 > root.data){
			return recfindLeastCommon(root.right,key1,key2);
		}
		return null;		
	}
	static Node ans;
	static Node findKsmallest(Node root){
		if(root == null || k <0){
			return root;
		}
			findKsmallest(root.left);
			k--;
			if(k==0)
				ans = root;
			findKsmallest(root.right);			
		return ans;
	}

}
