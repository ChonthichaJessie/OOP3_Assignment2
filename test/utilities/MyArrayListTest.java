/**
 * 
 */
package utilities;
import java.util.NoSuchElementException;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author nguye
 *
 */
class MyArrayListTest
{
	private ListADT<String> list1;
	private ListADT<String> list2;
	private ListADT<String> list3;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		list1 = new MyArrayList<>();
		list2 = new MyArrayList<>();
		list3 = new MyDLL<>();
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeEmpty()
	{
		assertEquals(0, list1.size());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeNotEmpty()
	{
		list1.add("A");
		assertEquals(1, list1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	void testClear()
	{
		list1.add("A");
		list1.clear();
		assertEquals(0, list1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEBeginning()
	{
		list1.add("B");
		assertTrue(list1.add(0, "A"));
		assertEquals(2, list1.size());
		assertEquals("A", list1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEMiddle()
	{
		list1.add("A");
		list1.add("C");
		assertTrue(list1.add(1, "B"));
		assertEquals(3, list1.size());
		assertEquals("B", list1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEEnd()
	{
		list1.add("A");
		assertTrue(list1.add(1, "B"));
		assertEquals(2, list1.size());
		assertEquals("B", list1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENullPointer()
	{
		assertThrows(NullPointerException.class, ()-> list1.add(0, null));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEIndexOutOfBoundsNegative()
	{
		assertThrows(IndexOutOfBoundsException.class, ()-> list1.add(-1, "A"));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEIndexOutOfBoundsPositive()
	{
		assertThrows(IndexOutOfBoundsException.class, ()-> list1.add(1, "A"));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntECapacity()
	{
		for(int i =0; i<1000; i++)
		{
			assertTrue(list1.add(0, "A"));
		}
		assertEquals(1000, list1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddEEmpty()
	{
		assertTrue(list1.add("A"));
		assertEquals(1, list1.size());
		assertEquals("A", list1.get(list1.size() -1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddENotEmpty()
	{
		list1.add("A");
		assertTrue(list1.add("B"));
		assertEquals(2, list1.size());
		assertEquals("B", list1.get(list1.size()-1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddENullPointer()
	{
		assertThrows(NullPointerException.class, ()->list1.add(null));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddECapacity()
	{
		for(int i = 0; i < 1000; i++)
		{
			assertTrue(list1.add("A"));
		}
		assertEquals(1000, list1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllArrayList()
	{
		list1.add("A");
		list2.add("B");
		assertTrue(list1.addAll(list2));
		assertEquals(2, list1.size());
		assertEquals("B", list1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllDLL()
	{
		list1.add("A");
		list3.add("B");
		assertTrue(list1.addAll(list3));
		assertEquals(2, list1.size());
		assertEquals("B", list1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllDLLNullPointer()
	{
		assertThrows(NullPointerException.class, ()->list1.addAll(null));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGetBeginning()
	{
		list1.add("A");
		list1.add("B");
		list1.add("C");
		assertEquals("A", list1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGetMiddle()
	{
		list1.add("A");
		list1.add("B");
		list1.add("C");
		assertEquals("B", list1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGetEnd()
	{
		list1.add("A");
		list1.add("B");
		list1.add("C");
		assertEquals("C", list1.get(2));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGetIndexOutOfBoundsPositive()
	{
		assertThrows(IndexOutOfBoundsException.class, ()->list1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGetIndexOutOfBoundsZero()
	{
		assertThrows(IndexOutOfBoundsException.class, ()->list1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGetIndexOutOfBoundsNegative()
	{
		assertThrows(IndexOutOfBoundsException.class, ()->list1.get(-1));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveInt()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmpty()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContains()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	void testToArray()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	void testIteratorEmpty()
	{
		Iterator<String> it = list1.iterator();
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, ()-> it.next());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	void testIteratorNotEmpty()
	{
		list1.add("A");
		list1.add("B");
		Iterator<String> it = list1.iterator();
		assertTrue(it.hasNext());
		assertEquals("A", it.next());
		assertEquals("B", it.next());
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, ()->it.next());
	}

}
