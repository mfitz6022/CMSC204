
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedList_STUDENT_Test 
{
	BasicDoubleLinkedList<Double> testBasicList;
	DoubleComparator testComparator;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		testBasicList = new BasicDoubleLinkedList<Double>();
		testComparator = new DoubleComparator();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		testBasicList = null;
		testComparator = null;
	}

	@Test
	void testGetSize() 
	{
		assertEquals(testBasicList.getSize(), 0);
		testBasicList.addToFront(1.0);
		assertEquals(testBasicList.getSize(), 1);
		testBasicList.addToFront(1.0);
		assertEquals(testBasicList.getSize(), 2);
		testBasicList.addToFront(1.0);
		assertEquals(testBasicList.getSize(), 3);
	}

	@Test
	void testAddToEnd() 
	{
		testBasicList.addToEnd(3.0);
		testBasicList.addToEnd(5.0);
		assertEquals(5.0, testBasicList.getLast());
		testBasicList.addToEnd(8.0);
		assertEquals(8.0,testBasicList.getLast());
		testBasicList.addToEnd(9.6);
		assertEquals(9.6,testBasicList.getLast());
	}

	@Test
	void testAddToFront() 
	{
		testBasicList.addToFront(3.0);
		testBasicList.addToFront(5.0);
		assertEquals(5.0, testBasicList.getFirst());
		testBasicList.addToFront(8.0);
		assertEquals(8.0,testBasicList.getFirst());
		testBasicList.addToFront(9.6);
		assertEquals(9.6,testBasicList.getFirst());
	}

	@Test
	void testRemove() 
	{
		testBasicList.addToFront(1.0);
		testBasicList.addToFront(3.0);
		testBasicList.addToFront(5.0);
		testBasicList.remove(5.0, testComparator);
		assertEquals(testBasicList.getFirst(), 3.0);
	}

	@Test
	void testRetrieveFirstElement() 
	{
		testBasicList.addToFront(1.0);
		testBasicList.addToFront(3.0);
		testBasicList.addToFront(5.0);
		assertEquals(5.0, testBasicList.retrieveFirstElement());
		assertEquals(3.0, testBasicList.retrieveFirstElement());
		testBasicList.addToFront(8.0);
		testBasicList.addToFront(9.6);
		assertEquals(9.6, testBasicList.retrieveFirstElement());
		assertEquals(8.0, testBasicList.retrieveFirstElement());
	}

	@Test
	void testRetrieveLastElement() 
	{
		testBasicList.addToEnd(1.0);
		testBasicList.addToEnd(3.0);
		testBasicList.addToEnd(5.0);
		assertEquals(5.0, testBasicList.retrieveLastElement());
		assertEquals(3.0, testBasicList.retrieveLastElement());
		testBasicList.addToEnd(8.0);
		testBasicList.addToEnd(9.6);
		assertEquals(9.6, testBasicList.retrieveLastElement());
		assertEquals(8.0, testBasicList.retrieveLastElement());
	}

	@Test
	void testToArrayList() 
	{
		ArrayList<Double> arrayList;
		testBasicList.addToFront(1.0);
		testBasicList.addToFront(3.0);
		testBasicList.addToFront(5.0);
		arrayList = testBasicList.toArrayList();
		assertEquals(5.0, arrayList.get(0));
		assertEquals(3.0, arrayList.get(1));
		assertEquals(1.0, arrayList.get(2));
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}

}
