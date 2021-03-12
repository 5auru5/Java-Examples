package binTree;
/**
* The Bintree program implements an application that
* displays a binarytree.
* @author  Arya Habibi
* @version 1.1
* @since   2019-09-11 
*/
public class Node /** Node class */
{ 
	protected
    int key; 
    Node left;
    Node right; 

    public
    Node(int key) /** Node constructor */
    { 
        this.key = key; 
        left = null;
        right = null; 
    } 
} 