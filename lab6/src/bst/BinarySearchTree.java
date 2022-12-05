package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		size =0;
		root = null;
		comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);


	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		size =0;

		root = null;
		this.comparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if(root == null){
			root = new BinaryNode<>(x);
			size++;
			return true;
		}else{
			return add(root,x);
		}


	}

	private boolean add(BinaryNode<E> n, E x){


			int i = comparator.compare(x,n.element);
			if(i < 0){
				if(n.left == null) {
					n.left = new BinaryNode<>(x);
					size++;
					return  true;
				}else{
					return add(n.left,x);
				}
			}else if(i>0){
				if(n.right == null) {
					size++;

					n.right = new BinaryNode<>(x);
					return true;
				}else{
					return add(n.right,x);
				}
			}


		return false;
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {

		return calculateHeight(root);


	}
	private int calculateHeight(BinaryNode<E> binaryNode){
		if (binaryNode == null) {
			return 0;
		}
		return 1 + Math.max(calculateHeight(binaryNode.left), calculateHeight(binaryNode.right));
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {


		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}

	private void printTree(BinaryNode<E> node){
		if(node != null){
			printTree(node.left);
			System.out.println(node.element);
			printTree(node.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}


	}
	
}
