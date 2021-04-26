package ch15;

import java.util.StringTokenizer;

public class StackTest2 {
	public static void main(String[] args) {
		String str = "apple, banana, carrot, pineapple, grape, mango, strawberry, watermelon, melon, orange, coconut, kiwi, lemon, tomato, cherry, blueberry, peach, cramberry, raspberry";
		String s;
		
		// 공백 문자를 기준으로 짜르는 법
		// StringTokennizer :
		// 구분자를 입력하고 구분자로 구분되는 문자열을 뽑아 쓸수있게 해줌
		
		//String str, String delim
		StringTokenizer st = new StringTokenizer(str, ", ");
//		String s = st.nextToken();
		
		System.out.println(st.countTokens());
		
		//1. 토큰의 수만큼 for 문 돌기
		for(int i = 0; i < st.countTokens(); i++) {
			s = st.nextToken();
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		st = new StringTokenizer(str, ", ");
		
		//2. 아직 나에게 줄 토큰이 남아있는지 물어보고 있다면 nextToken() 을 이용해 사용하기 주로 이용
		while(st.hasMoreTokens()) {
			s = st.nextToken();
			System.out.print("[" + s + "]");
		}
		
	}
}
