import java.util.Random;


public class RandomNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		//System.out.print(rand.nextLong());
		System.out.println(Math.round(Math.pow(2, Double.MAX_VALUE)));

		System.out.println(Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
	}

}
