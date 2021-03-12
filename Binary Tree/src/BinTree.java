package binTree;
/**
* The Bintree program implements an application that
* displays a binarytree.
* @author  Arya Habibi
* @version 1.1
* @since   2019-09-11 
*/
public class BinTree/** bintree class */
{ 

 Node root; //The root of every bintree

 public BinTree() /** Constructor  for bintree */
 {  
     root = null;  
 } 
 public void insertNode (Node n) 
 {

	 root = insert(root, n);

}


 public Node insert(Node root, Node n) /** insert new key  onto tree recursive */
 { 


     if (root == null) //if there is nothing in the root (empty tree) create new root
     { 
         root = n; 
         return root; 
     } 

     if (n.key < root.key)  //otherwise go down tree to find proper spot. 
         root.left = insert(root.left, n); 
     else if (n.key > root.key) 
         root.right = insert(root.right, n); 
     return root; 
 } 

 public void treeWalk() /** calls walk function from root of tree */
 { 
	 Walk(root); 
 } 
 
 public void Walk(Node root) /** Walk driver function. */
 { 
     if (root != null) 
     { 
         Walk(root.left); 
         System.out.println(root.key); 
         Walk(root.right); 
     }
 }
}