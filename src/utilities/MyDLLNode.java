package utilities;

import java.io.Serializable;

public class MyDLLNode<E> implements Serializable
{
	private static final long serialVersionUID = -3278755004553223701L;
	E element;
	private MyDLLNode<E> prev, next;
	
	public MyDLLNode(E elem, MyDLLNode<E> prev, MyDLLNode<E> next)
	{
		this.element = elem;
		this.setPrev(prev);
		this.next = next;
	}
	
	public MyDLLNode(E elem)
	{
		this.element = elem;
	}

	public MyDLLNode<E> getPrev() {
		return prev;
	}
	
	public MyDLLNode<E> getNext() {
		return next;
	}

	public void setPrev(MyDLLNode<E> prev) {
		this.prev = prev;
	}
	
	public void setNext(MyDLLNode<E> next) {
		this.next = next;
	}
	
	
	
}
