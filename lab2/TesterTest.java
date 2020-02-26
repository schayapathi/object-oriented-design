package lab2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesterTest {

	@Test
	void testa() {
		int [] a =  new int[] {5, 4, 1, 9, 2, 6};
		assertArrayEquals(a, Arrays.swapLargestAndSmallest(a));
	}
	@Test
	void testb() {
		
		int [] b =  new int[] {1, 4, 1, 9, 2, 6};
		assertArrayEquals(b, Arrays.swapLargestAndSmallest(b));
	}
	@Test
	void testc() {
		
		int [] c =  new int[] {1, 4, 2, 9, 9, 6};
		assertArrayEquals(c, Arrays.swapLargestAndSmallest(c));
	}
	@Test
	void testd() {
		
		int [] d =  new int[] {1};
		assertArrayEquals(d, Arrays.swapLargestAndSmallest(d));
		
	}

}
