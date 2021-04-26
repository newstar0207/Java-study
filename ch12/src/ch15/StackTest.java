package ch15;

import java.util.Stack; // util 이란 편이기능을 의미

public class StackTest {
	public static void main(String[] args) {
		// stack : LIFO(Last In First Out)
		// Generic : 클래스 내부에서 사용할 데이터 타입이 정해진 것이 아닌,
		// 그 클래스의 객체를 생성할 때 데이터 타입을 결정할 수 있도록, 시영힐 타입을
		// 파라미터로 받아서 객체를 생성하는 것.
		// 타입 파라미터 (Type Parameter)
		// primitive type 은 넣을 수없음!
		Stack<Integer> stack = new Stack<>();
		//stack 은 주로 괄호의 갯수가 맞거나 같은 확인하는 용도로 많이 쓰이는듯함
		for( int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		
		System.out.println(stack);

		while(! stack.isEmpty()) {
			Integer val = stack.pop();
			System.out.println(val);
		}
	}
}
