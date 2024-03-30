package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E>
{
	private static final long serialVersionUID = -6641976547739553233L;
	private final int CAPACITY = 10;
	private E[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList()
	{
		array = (E[]) new Object[CAPACITY];
	}

	@Override
	public int size()
	{
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear()
	{
		array = (E[]) new Object[CAPACITY];
		size = 0;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException
	{
		if(toAdd == null)
			throw new NullPointerException();
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		checkCapacity();
		for(int i = size; i > index; i--)
		{
			array[i] = array[i-1];
		}
		array[index] = toAdd;
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	private void checkCapacity()
	{
		if(size == array.length)
		{
			E[] newArray = (E[]) new Object[size * 2];
			for(int i = 0; i < array.length; i++)
			{
				newArray[i] = array[i];
			}
			array = newArray;
		}
		
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException
	{
		if(toAdd == null)
			throw new NullPointerException();
		checkCapacity();
		array[size++] = toAdd;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
		@Override
		public E [] toArray (E [] toHold) throws NullPointerException
		{
			if(toHold == null)
			{
				throw new NullPointerException("Cannot copy to a null array.");
			}
			
			if (toHold.length < size)
			{
				toHold = (E[]) (Array.newInstance(toHold.getClass().getComponentType(), size));
			}
			
			for (int i = 0; i < size; i++)
			{
				toHold[i] = (E) array[i];
			}
			
			if(toHold.length > size)
			{
				toHold[size] = null;
			}
			
			
			return toHold;
		}
	 
		/* (non-Javadoc)
		 * @see linearUtilities.List#toArray()
		 */
		@Override
		@SuppressWarnings("unchecked")
		public Object[] toArray()
		{
			//E[] toReturn = (E[]) (new Object[size]);
			Object[] toReturn = (Object[]) Array.newInstance(Object.class, size);
			/*for(int i = 0; i < size(); i++)
			{
				toReturn[i] = ((E)array[i]).
			}*/
			System.arraycopy(array, 0, toReturn, 0, size());
			return toReturn;
		}

	@Override
	public Iterator<E> iterator()
	{
		return new ArrayBasedIterator();
	}
	
	private class ArrayBasedIterator implements Iterator<E>
	{
 
		private E[] copyOfElements;
		private int pos;
		
		@SuppressWarnings("unchecked")
		public ArrayBasedIterator()
		{
			copyOfElements = (E[]) new Object[size];
			System.arraycopy(array, 0, copyOfElements, 0, copyOfElements.length);
		}
		@Override
		public boolean hasNext()
		{
			return pos < copyOfElements.length;
		}
 
		@Override
		public E next() throws NoSuchElementException
		{
			if(pos == copyOfElements.length)
				throw new NoSuchElementException();
			return copyOfElements[pos++];
		}
		
	}

}
