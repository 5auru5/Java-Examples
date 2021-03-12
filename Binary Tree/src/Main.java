package binTree;
/**
* The Bintree program implements an application that
* displays a binarytree.
* @author  Arya Habibi
* @version 1.1
* @since   2019-09-11 
*/
public class Main {

	public static void main(String[] args) {

		// testcase 2
				System.out.println();
				System.out.println("testcase 1:");
				BinTree binTree2 = new BinTree();
				binTree2.insertNode(new Node(3));
				binTree2.insertNode(new Node(201));
				binTree2.insertNode(new Node(60));
				binTree2.insertNode(new Node(30));
				binTree2.insertNode(new Node(45));
				binTree2.treeWalk();
				
				// testcase 3
				System.out.println();
				System.out.println("testcase 2_1:");
				BinTree binTree3 = new BinTree();
				binTree3.insertNode(new Node(-10));
				binTree3.insertNode(new Node(-150));
				binTree3.insertNode(new Node(4));
				binTree3.insertNode(new Node(300));
				binTree3.insertNode(new Node(45));
				binTree3.treeWalk();
				binTree3.insertNode(new Node(-50));
				binTree3.insertNode(new Node(200));
				System.out.println();
				System.out.println("testcase 2_2:");
				binTree3.treeWalk();


	}

}
