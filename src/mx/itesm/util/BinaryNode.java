package mx.itesm.util;

public class BinaryNode<E> {
	
	public E value;
	public BinaryNode<E> leftChild;
	public BinaryNode<E> rightChild;
	
	public BinaryNode() {
		value = null;
		leftChild = null;
		rightChild = null;
	}
	
	public BinaryNode(E value) {
		this.value = value;
		leftChild = null;
		rightChild = null;
	}
	
	public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right) {
		this.value = value;
		this.leftChild = left;
		this.rightChild = right;
	}
	
	public E data() {
		return value;
	}
	
	public void setData (E newValue) {
		value = newValue;
	}
	
	public BinaryNode<E> Right() {
        return rightChild;
    }

    public BinaryNode<E> Left() {
        return leftChild;
    }

    public void setRight(BinaryNode<E> bNode) {
        rightChild = bNode;
    }

    public void setLeft(BinaryNode<E> bNode) {
        leftChild = bNode;
    }
}

