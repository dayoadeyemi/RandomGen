import java.util.Random;

public class RandomGen {
	// Values that may be returned by nextNum()
	private int[] randomNums;
	// Probability of the occurence of randomNums
	private float[] probabilities;
	
	private Random random;
	
	RandomGen(int[] randomNums, float[] probabilities, long seed){
		random = new Random(seed);
		if (randomNums.length != probabilities.length){
			throw new IllegalArgumentException("the number or random numbers and"
					+ " the number of probabilities must match");
		}
		float sum = 0f;
		for (int i = 0; i < probabilities.length; i++) {
			if (probabilities[i] < 0f || probabilities[i] > 1f){
				throw new IllegalArgumentException("each of the probabilities must be between 0 and 1");
			}
			sum += probabilities[i];
		}
		if (sum != 1f){
			throw new IllegalArgumentException("the probabilities must sum to 1");
		}
		this.randomNums = randomNums;
		this.probabilities = probabilities;
	}

	RandomGen(int[] randomNums, float[] probabilities){
		this(randomNums, probabilities, System.currentTimeMillis());
	}
	
	public int nextNum() {
		float randomFloat = random.nextFloat();
		for (int i = 0; i < probabilities.length; i++) {
			if (probabilities[i] > randomFloat) {
				return randomNums[i];
			} else {
				randomFloat -= probabilities[i];
			}
		}
		return 0;
	}
}
