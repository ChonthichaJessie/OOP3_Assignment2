package utilities;

public class MyDLL<E> implements ListADT<E> {
	private static final long serialVersionUID = -7140796753013938413L;
	private MyDLLNode<E> head, tail;
	private int size;

	public MyDLL() {
		head = tail = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;

	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null)
			throw new NullPointerException();
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (index == 0 && head == null) {
			MyDLLNode<E> newNode = new MyDLLNode<>(toAdd, null, null);
			head = newNode;
			tail = head;
		} else if (index == 0 && head != null) {
			MyDLLNode<E> newNode = new MyDLLNode<>(toAdd, null, head);
			head.setPrev(newNode);
			head = newNode;
		} else if (index > 0 && index < size - 1 && head != null) {

		}

		size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null)
			throw new NullPointerException();
		if (head == null) {
			MyDLLNode<E> newNode = new MyDLLNode<>(toAdd, null, null);
			head = newNode;
			tail = head;
		} else {
			MyDLLNode<E> newNode = new MyDLLNode<>(toAdd, null, head);
			head.setPrev(newNode);
			head = newNode;
		}

		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd.size() == 0)
			throw new NullPointerException();

		if (head == null) {
			MyDLLNode<E> newNode = new MyDLLNode<>(toAdd.get(0), null, head);
			head.setPrev(newNode);
			head = newNode;
			tail = head;
			size++;
			for (int i = 1; i < toAdd.size(); i++) {
				MyDLLNode<E> newNextNode = new MyDLLNode<>(toAdd.get(i), null, head);
				head.setPrev(newNextNode);
				head = newNextNode;
				size++;
			}
		} else {
			for (int i = 0; i < toAdd.size(); i++) {
				MyDLLNode<E> newNextNode = new MyDLLNode<>(toAdd.get(i), null, head);
				head.setPrev(newNextNode);
				head = newNextNode;
				size++;
			}
		}

		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException();

		MyDLLNode<E> current;
		current = head;
		E indexedElement = null;

		if (index == 0) {
			indexedElement = current.element;
		}

		if (index > 0 && index <= size) {
			for (int i = 1; i < size; i++) {
				current = current.getNext();
				indexedElement = current.element;
			}
		}

		return indexedElement;
	}

	private E remove(MyDLLNode<E> node) {
		MyDLLNode<E> prev = node.getPrev();
		MyDLLNode<E> next = node.getNext();
		if (node == head) {
			head = node.getNext();
		} else if (node == tail) {
			tail = node.getPrev();
		}
		if (prev != null) {
			prev.setNext(next);
		}
		if (next != null) {
			next.setPrev(prev);
		}
		node.setNext(null);
		node.setPrev(null);
		return node.element;
	}
	
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();

		MyDLLNode<E> at = head;
		int i = 0;
		while (at != null && i != index) {
			at = at.getNext();
			i++;
		}
		
		if (at != null) {
			return remove(at);
		}
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null)
			throw new NullPointerException();

		MyDLLNode<E> at = head;
		while (at != null && at != toRemove) {
			at = at.getNext();
		}
		
		if (at != null) {
			return remove(at);
		}
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
