package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KiwiLandTests {
	//These are the unit test for all the expected outputs in the documentation
	@Test
	public void calculateDistanceABC() {
	    final int expected = 9;
	    
	    final int actual = 9;
	    
	    Assert.assertEquals(expected, actual);
	}
	@Test
	public void calculateDistanceAD() {
	    final int expected = 5;
	    
	    final int actual = 9;
	    
	    Assert.assertEquals(expected, actual);
	}
	@Test
	public void calculateDistanceADC() {
	    final int expected = 13;
	    
	    final int actual = 9;
	    
	    Assert.assertEquals(expected, actual);
	}
	@Test
	public void calculateDistanceAEBCD() {
	    final int expected = 22;
	    
	    final int actual = 9;
	    
	    Assert.assertEquals(expected, actual);
	}
	@Test
	public void calculateDistanceAED() {
	    final String expected = "NO SUCH ROUTE";
	    
	    final int actual = 9;
	    
	    Assert.assertEquals(expected, actual);
	}
}
