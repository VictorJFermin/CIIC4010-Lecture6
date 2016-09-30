import static org.junit.Assert.*;
import org.junit.Test;

public class ArraySetLongTest {
	
	long[] a = {1,2,3,4,5};
	ArraySetLong s = new ArraySetLong(a, 5);
	ArraySetLong emptySet = new ArraySetLong(10);

	@Test
	public void testBasic1() {
		ArraySetLong s = new ArraySetLong(10);
		assertNotNull("ArraySetLong(10): Null object reference returned", s);
		assertTrue("ArraySetLong(10): Non-empty set returned", s.isEmpty());
	}
	
	@Test
	public void testBasic2() {
		assertNotNull("ArraySetLong(a,5): Null object reference returned", s);
		assertFalse("ArraySetLong(a,5): Non-empty set returned", s.isEmpty());
		assertEquals("ArraySetLong(a,5): Non-empty set returned", s.cardinality(),5);
	}
	
	@Test
	public void testMaxMin() {
		assertEquals("max(): Wrong max returned", s.max(),5);
		assertEquals("min(): Wrong min returned", s.min(),1);
	}
	
	@Test
	public void testSum() {
		assertEquals("sum(): Wrong sum returned", s.sum(),15);
	}
	
	@Test
	public void testProduct() {
		assertEquals("product(): Wrong product returned", s.product(),120);
	}
	
	@Test
	public void testIsMember() {
		assertTrue("isMember(): Did not find set member", s.isMember(5));
		assertFalse("isMember(): Found non-existant member", s.isMember(6));
		assertFalse("isMember(): Number found in empty set", emptySet.isMember(6));
	}
	
	@Test
	public void testAddMember() {
		s.addMember(6);
		assertTrue("isMember(): Did not find added set member", s.isMember(6));
	}
	
	@Test
	public void testDeleteMember() {
		s.deleteMember(5);
		assertFalse("isMember(): Found a delete element", s.isMember(5));
	}

}
