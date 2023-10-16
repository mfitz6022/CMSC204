import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedDoubleLinkedList_STUDENT_Test 
{
	SortedDoubleLinkedList<Double> testSortedList;
	DoubleComparator testComparator;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		testComparator = new DoubleComparator();
		testSortedList = new SortedDoubleLinkedList<Double>(testComparator);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		testComparator = null;
		testSortedList = null;
	}

	@Test
	void testAddToEnd() 
	{
		try {
			testSortedList.addToEnd(8.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	void testAddToFront() 
	{
		try {
			testSortedList.addToFront(6.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	void testAdd() 
	{
		Double a = 15.0;
		Double b = 6.3;
		testSortedList.add(a);
		testSortedList.add(b);
		assertEquals(testSortedList.getFirst(), b);
		assertEquals(testSortedList.getLast(), a);
		
	}

	@Test
	void testRemove() 
	{
		Double a = 15.0;
		Double b = 6.3;
		Double c = 7.7;
		testSortedList.add(a);
		testSortedList.add(b);
		testSortedList.add(c);
		assertEquals(testSortedList.getFirst(), b);
		assertEquals(testSortedList.getLast(), a);
		testSortedList.remove(a, testComparator);
		assertEquals(testSortedList.getLast(), c);
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			return arg0.compareTo(arg1);
		}
		
	}

}
