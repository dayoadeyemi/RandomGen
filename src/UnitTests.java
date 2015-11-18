import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class UnitTests {

	@Test
	public void runsOnSigleItemArray() {
		RandomGen randomGen = new RandomGen(new int[] { 1337 }, new float[] { 1 }, 1000);
		assertEquals(randomGen.nextNum(), 1337);
		assertEquals(randomGen.nextNum(), 1337);
		assertEquals(randomGen.nextNum(), 1337);
		assertEquals(randomGen.nextNum(), 1337);
	}

	@Test
	public void runsOnStandardInput() {
		int[] randomNums = new int[] { 1, 2, 3, 4, 5 };
		float[] probabilities = new float[] { 0.01f, 0.3f, 0.58f, 0.1f, 0.01f };
		RandomGen randomGen = new RandomGen(randomNums, probabilities, 1234567);

		int[] sums = new int[] { 0, 0, 0, 0, 0 };

		for (int i = 0; i < 10000; i++) {
			int randomNum = randomGen.nextNum();
			//should never fall into returning 0
			assertNotEquals(randomNum, 0);
			sums[randomNum-1]++;
		}

		System.out.println("1: " + sums[0]);
		System.out.println("2: " + sums[1]);
		System.out.println("3: " + sums[2]);
		System.out.println("4: " + sums[3]);
		System.out.println("5: " + sums[4]);
	}
}
