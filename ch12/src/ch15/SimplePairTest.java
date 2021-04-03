package ch15;

public class SimplePairTest {
	
	
	public static void main(String[] args) {
		
		SimplePair<String> pair = new SimplePair<>("apple", "tomato");
		System.out.println(pair.getData1() + " " + pair.getData2());
		
		SimplePair<Integer> pair2 = new SimplePair<>(1 , 3);
		System.out.println(pair2.getData1() + " " + pair2.getData2());
		
		SimplePair<Boolean> pair3 = new SimplePair<>(true, false);
		System.out.println(pair3.getData1() + " " + pair3.getData2());
	}
}
