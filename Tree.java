public class Tree{
	public Node root;
	//constructor that takes in the sorted array (in increasing order with unique integer elements)
	public Tree(int[] arr){
		//use this recursive helper function to create the tree
		root = createTree(arr, 0, arr.length-1);
	}

	//helper function that recursively finds the center of the subarray and makes it the root of the subtree
	public Node createTree(int [] arr, int start, int end){
		//indicating there is at least one element in the subarray
		if(end - start >= 0){
			//this formula will find the middle element of the sorted array
			int mid = (end+start)/2;
			Node root = new Node(arr[mid]);
			root.left = createTree(arr, start, mid-1);
			root.right = createTree(arr, mid+1, end);
			return root;
		}
		return null;
	}
	//prints all 3 traversals--can be used to check the tree after creation because having all 3 can uniquely identify a tree
	public void printTreeTraversals(){
		System.out.println("Pre-Order Traversal: ");
		printPreOrderTraversal(root);
		System.out.println();
		System.out.println("In-Order Traversal: ");
		printInOrderTraversal(root);
		System.out.println();
		System.out.println("Post-Order Traversal: ");
		printPostOrderTraversal(root);
	}
	public void printPreOrderTraversal(Node root){
		if(root != null){
			System.out.print(root + " ");
			printPreOrderTraversal(root.left);
			printPreOrderTraversal(root.right);
		}
	}
	public void printPostOrderTraversal(Node root){
		if(root != null){
			printPostOrderTraversal(root.left);
			printPostOrderTraversal(root.right);
			System.out.print(root + " ");
		}
	}
	public void printInOrderTraversal(Node root){
		if(root != null){
			printInOrderTraversal(root.left);
			System.out.print(root + " ");
			printInOrderTraversal(root.right);
		}
	}
}
